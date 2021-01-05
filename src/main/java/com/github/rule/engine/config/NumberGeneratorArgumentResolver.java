package com.github.rule.engine.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author LuoFuMin
 * @DATE 2020/12/28 12:45
 */
public class NumberGeneratorArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        NumberGenerator numberGenerator = methodParameter.getParameterAnnotation(NumberGenerator.class);
        return numberGenerator != null ? true : false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        // 判断参数类型进行返回
        Class<?> parameterType = methodParameter.getParameterType();
        System.out.println("parameterType ==" + parameterType.getName());
        return null;
    }
}
