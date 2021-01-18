package com.github.rule.engine.dto;


import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

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


    private volatile boolean handleResult = true;

    public boolean isHandleResult() {
        return handleResult;
    }

    public synchronized void setHandleResult(boolean handleResult) {
        this.handleResult = handleResult;
    }



    /**
     * 错误信息
     */
    private volatile StringBuilder errorMsg;

    public void addErrorMsg(String msg) {
        if (null == this.errorMsg) {
            this.errorMsg = new StringBuilder();
        }
        this.errorMsg.append(msg);
    }

    public String getErrorMsg() {
        if (null == this.errorMsg) {
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
