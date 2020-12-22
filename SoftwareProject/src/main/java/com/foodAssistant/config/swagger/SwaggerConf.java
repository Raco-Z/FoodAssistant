package com.foodAssistant.config.swagger;

import io.swagger.models.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConf {

    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("foodAssistant")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.foodAssistant.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){


            return new ApiInfo("营养小助手API文档",
                    "营养小助手查询食品列表的API",
                    "v1.0",
                    "https://github.com/RookieofRookies/FoodAssistant",
                    "foodAssistant",
                    "Apache 2.0",
                    "http://www.apache.org/licenses/LICENSE-2.0"
                    );

    }
}
