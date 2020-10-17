package com.github.rule.engine.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dto.ValueSetExcelDTO;
import com.github.rule.engine.dto.ValueSetRequest;
import com.github.rule.engine.entity.Application;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.mapper.ApplicationMapper;
import com.github.rule.engine.mapper.ApplicationTemplateMapper;
import com.github.rule.engine.mapper.ValueSetMapper;
import com.github.rule.engine.entity.ValueSet;
import com.github.rule.engine.service.ValueSetService;
import com.github.rule.engine.utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 值集表(TValueSet)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 22:30:17
 */
@Service
public class ValueSetServiceImpl extends ServiceImpl<ValueSetMapper, ValueSet> implements ValueSetService {
    @Resource
    private ValueSetMapper valueSetMapper;

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    ApplicationTemplateMapper applicationTemplateMapper;

    @Autowired
    private HttpServletResponse response;


    @Override
    public R<?> findvalueSet(ValueSetRequest valueSetRequest) {
        List list = valueSetMapper.findvalueSet(valueSetRequest);
        return R.ok(list);
    }

    @Override
    @Transactional
    public R<?> importValueSet(MultipartFile file, String applicationId) throws Exception {
        Workbook workbook = ExcelUtils.getWorkBook(file);
        if (null == workbook) {
            return R.failed("导入数据为空");
        }
        ExcelImportResult excelImportResult = null;
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            excelImportResult = getExcelData(file, i);
            if (!CollectionUtils.isEmpty(excelImportResult.getFailList())) {
                return R.failed(excelImportResult.getFailList().toString());
            }
            if (CollectionUtils.isEmpty(excelImportResult.getList())) {
                return R.failed("导入数据为空");
            }
            String sheetName = workbook.getSheetName(i);
            String[] segments = sheetName.split("-");
            if (null == segments || segments.length < 2) {
                return R.failed("sheet名称错误");
            }
            Application application = applicationMapper.selectById(applicationId);
            if (null == application) {
                return R.failed("应用为空");
            }
            QueryWrapper<ApplicationTemplate> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("application_id", applicationId);
            queryWrapper.eq("segment_code", segments[0]);
            queryWrapper.eq("segment_name", segments[1]);
            queryWrapper.eq("status", "1");
            boolean exits = applicationTemplateMapper.selectCount(queryWrapper) < 1;
            if (exits) {
                return R.failed("不存在 " + sheetName);
            }
            //使用临时表避免导入重复值
            valueSetMapper.insertBatchTemp(excelImportResult.getList(), applicationId, segments[0], segments[1], application.getRootId());
            int count = valueSetMapper.copyInsertBatch();
        }
        return R.ok(null);
    }

    @Override
    public void getExcelTemplate(String applicationId) throws IOException {
        List<ApplicationTemplate> applicationTemplateList = applicationTemplateMapper.findListByApplicationId(applicationId);
        // 将sheet1、sheet2、sheet3使用得map进行包装
        List<Map<String, Object>> sheetsList = new ArrayList<>();
        for (int i = 0; i < applicationTemplateList.size(); i++) {
            ApplicationTemplate template = applicationTemplateList.get(i);
            String sheetName = template.getSegmentCode() + "-" + template.getSegmentName();
            ExportParams empExportParams = new ExportParams();
            empExportParams.setSheetName(sheetName);
            Map<String, Object> sheetExportMap = new HashMap<>();
            sheetExportMap.put("title", empExportParams);
            sheetExportMap.put("entity", ValueSetExcelDTO.class);
            sheetExportMap.put("data", new ArrayList<>());
            sheetsList.add(sheetExportMap);
        }
        Workbook workBook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
        ExcelUtils.downloadExcel(response, workBook, "值集导入模板");
    }

    private ExcelImportResult getExcelData(MultipartFile file, int sheetIndex) throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        //距离表头中间有几行不要的数据
        params.setStartRows(0);
        //第几个sheet页
        params.setStartSheetIndex(sheetIndex);
        //验证数据
        params.setNeedVerify(true);
        //过滤空行数据
        params.setKeyIndex(0);
        ExcelImportResult result = ExcelImportUtil.importExcelMore(
                file.getInputStream(),
                ValueSetExcelDTO.class, params);
        return result;
    }

}