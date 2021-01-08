package com.github.rule.engine.dto;


import java.time.LocalDateTime;

/**
 * 传递到管道的上下文
 *
 * @Author LuoFuMin
 * @DATE 2021/1/5 16:43
 */

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
     * 错误信息
     */
    private StringBuilder errorMsg;

    public void setErrorMsg(String msg) {
        if (null == this.errorMsg) {
            this.errorMsg = new StringBuilder();
        }
        this.errorMsg.append(msg);
    }

    public String getErrorMsg() {
        if (null == this.errorMsg.toString()) {
            return "";
        }
        return this.errorMsg.toString();
    }

    /**
     * 获取数据名称
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
