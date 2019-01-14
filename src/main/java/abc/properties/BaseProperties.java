package com.abc.tyc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:${spring.profiles.active}/env.properties")
@ConfigurationProperties
public class BaseProperties {
}
