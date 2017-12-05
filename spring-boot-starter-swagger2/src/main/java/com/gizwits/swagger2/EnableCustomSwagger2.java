package com.gizwits.swagger2;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by kevinchen on 2017/12/01.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({Swagger2Configuration.class})
public @interface EnableCustomSwagger2 {

}
