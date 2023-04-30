package com.greenjourneys.Configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi HoussemForumApi() {
        return GroupedOpenApi.builder().group("Forum 🏪")
                .pathsToMatch("/Comment/**","/publication/**","/reactionCont/**")
                .pathsToExclude("**")
                .build();}
}
