package com.github.rule.engine.handler;


import com.github.rule.engine.dto.PipelineContext;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/21 9:59
 */
public abstract class AbstractContextHandler<T extends PipelineContext> implements ContextHandler<T> {

    /**
     * 前置处理
     *
     * @param context
     * @return boolean
     */
    protected boolean beforeHandler(T context) {
        return context.getHandleResult();
    }


    public boolean doHandler(T context) {
        if (this.beforeHandler(context)) {
            return handle(context);
        }
        return false;
    }
}
