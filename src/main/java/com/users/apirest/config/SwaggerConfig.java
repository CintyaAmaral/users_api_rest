package com.users.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
		public Docket userApi() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.users.apirest"))
					.paths(PathSelectors.regex("/api.*"))
					.build()
					.apiInfo(metaInfo());
		}
		
		private ApiInfo metaInfo() {
			ApiInfo apiInfo = new ApiInfo(
					"Users API REST",
					"API REST de cadastro de usuários.",
					"1.0",
					"Terms of Service",
					new Contact("Cintya Amaral", "cintyaamaral22@gmail.com", null),
					"Apache License Version 2.0",
					"https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
			);
			
			return apiInfo;
		}
}
