package org.rule.engine.service;

import org.rule.engine.dto.ElementDTO;
import org.rule.engine.entity.Dictionary;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author work
 * @since 2022-08-15
 */
public interface DictionaryService extends IService<Dictionary> {

    Object treeList(ElementDTO elementDTO);
}
