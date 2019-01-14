package com.abc.tyc.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ApplicationProperties {
    public static String env;

    @Value("${spring.profiles.active}")
    public void setEnv(String env){
        ApplicationProperties.env = env;
    }
}
