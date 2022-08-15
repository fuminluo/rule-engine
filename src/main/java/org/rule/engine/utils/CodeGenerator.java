package org.rule.engine.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;


public class CodeGenerator {


    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/rule_engine?&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("work") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:/work/project/rule-engine/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.rule.engine") // 设置父包名
                            .moduleName("") // 设置父包模块名

                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\work\\project\\rule-engine\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_dictionary") // 设置需要生成的表名
                            .addTablePrefix("t_", "")
                    ; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();




    }


}