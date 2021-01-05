package com.github.rule.engine.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 传递到管道的上下文
 *
 * @Author LuoFuMin
 * @DATE 2021/1/5 16:43
 */
@Data
public class PipelineContext {
    /**
     * 处理开始时间
     */
    private LocalDateTime startTime;

    /**
     * 处理结束时间
     */
    private LocalDateTime endTime;

    /**
     * 获取数据名称
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
