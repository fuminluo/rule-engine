package com.github.rule.engine.dto;

import lombok.Data;

import java.util.Map;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/5 16:45
 */
@Data
public class InstanceBuildContext extends PipelineContext {
    /**
     * 模型 id
     */
    private Long modelId;

    /**
     * 用户 id
     */
    private long userId;

    /**
     * 表单输入
     */
    private Map<String, Object> formInput;

    /**
     * 保存模型实例完成后，记录下 id
     */
    private Long instanceId;

    /**
     * 模型创建出错时的错误信息
     */
    private String errorMsg;

    // 其他参数

    @Override
    public String getName() {
        return "模型实例构建上下文";
    }
}
