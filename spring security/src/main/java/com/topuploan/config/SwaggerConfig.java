package com.topuploan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	@Bean
	public Docket customerApi()
	{
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.topuploan.controller"))
				.build();
		return docket;
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("Topup Loan Portal")
				.description("Topup Loan")
				.termsOfServiceUrl("http://topuploan.com")
				.contact(new Contact("Topup Loan", "http://topuploan.com", "topuploan@gmail.com"))
				.license("Topuploan Licence")
				.licenseUrl("http://topuploanapi.com")
				.build();
	}

}
