package com.github.rule.engine.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.github.rule.engine.entity.ApplicationTemplate;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author Admin
 * @DATE 2020/10/16 19:49
 */
public class ExcelUtils {
    /**
     * 得到Workbook对象
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBook(MultipartFile file) throws IOException {
        //这样写  excel 能兼容03和07
        InputStream is = file.getInputStream();
        Workbook hssfWorkbook = null;
        try {
            hssfWorkbook = new HSSFWorkbook(is);
        } catch (Exception ex) {
            is = file.getInputStream();
            hssfWorkbook = new XSSFWorkbook(is);
        }
        return hssfWorkbook;
    }


    /**
     * @param response
     * @param wb
     * @param showFileName
     * @throws IOException
     */
    public static void downloadExcel(HttpServletResponse response, Workbook wb, String showFileName) throws IOException {
        // 判断数据
        if (wb == null) {
            return;
        }
        // 重置响应对象
        response.reset();
        // 当前日期，用于导出文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = showFileName + sdf.format(new Date()) + ".xls";
        // 指定下载的文件名--设置响应头
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(dateStr.getBytes("gb2312"), "ISO8859-1"));
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 写出数据输出流到页面
        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            wb.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
        //构造对象等同于@Excel
        ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
        excelentity.setNeedMerge(true);
        entity.add(excelentity);
        entity.add(new ExcelExportEntity("性别", "sex"));
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("测试");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, entity,
                new ArrayList<Map<String, Object>>());
        FileOutputStream fos = new FileOutputStream("D:/ExcelExportForMap.xls");
        workbook.write(fos);
        fos.close();
    }

}
