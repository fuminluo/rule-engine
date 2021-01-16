package com.github.rule.engine.dto;

import java.util.concurrent.CountDownLatch;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/11 18:52
 */
public class LatchPipelineContext extends PipelineContext {

    private CountDownLatch latch;

    private Boolean isContinue = true;

    /**
     * 等待时间 单位秒
     */
    private Integer waitTime;

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public Boolean getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Boolean aContinue) {
        this.isContinue = aContinue;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }
}
