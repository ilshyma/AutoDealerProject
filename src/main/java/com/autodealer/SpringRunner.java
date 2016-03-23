package com.autodealer;

import com.autodealer.config.Spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by user on 23.03.2016.
 */
public class SpringRunner {
    public static void main(String[] args) {
        final ApplicationContext appCtx =
                new AnnotationConfigApplicationContext(Spring.class);


    }
}
