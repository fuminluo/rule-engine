package org.rule.engine.controller;


import org.rule.engine.base.ResultInfo;
import org.rule.engine.dto.ElementDTO;
import org.rule.engine.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;


    @PostMapping("/tree")
    public ResultInfo<?> treeList(ElementDTO elementDTO){
       return ResultInfo.OK(dictionaryService.treeList(elementDTO));
    }

}
