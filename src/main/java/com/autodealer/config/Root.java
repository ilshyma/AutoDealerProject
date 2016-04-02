package com.autodealer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ilshyma on 01.04.2016.
 */

@EnableWebMvc
@Configuration
@ComponentScan({
        "com.autodealer.config",
        "com.autodealer.controller"
})
@Import(Persistence.class)

public class Root {
}
