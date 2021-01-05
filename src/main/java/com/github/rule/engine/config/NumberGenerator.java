package com.github.rule.engine.config;

import java.lang.annotation.*;

/**
 * @Author LuoFuMin
 * @DATE 2020/12/28 12:42
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NumberGenerator {
}
