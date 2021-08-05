package com.soumav.commonfw.configurations.spring;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {

	@Value("${server.servlet.context-path}")
	String contextPath;

	@Value("${swagger.scan.basepackage:}")
	String basePackage;
	@Value("${swagger.apiinfo.title:}")
	String title;
	@Value("${swagger.apiinfo.description:}")
	String description;
	@Value("${swagger.apiinfo.version:}")
	String version;
	@Value("${swagger.apiinfo.termsOfServiceUrl:}")
	String termsOfServiceUrl;
	@Value("${swagger.apiinfo.contact.name:}")
	String name;
	@Value("${swagger.apiinfo.contact.url:}")
	String url;
	@Value("${swagger.apiinfo.contact.email:}")
	String email;
	@Value("${swagger.apiinfo.contact.license:}")
	String license;
	@Value("${swagger.apiinfo.contact.licenseUrl:}")
	String licenseUrl;

	@Bean
	public Docket api() {
		Docket build = new Docket(DocumentationType.SWAGGER_2);
		try {
			build = new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant(contextPath + "/*"))
					.apis(RequestHandlerSelectors.basePackage(basePackage)).build().apiInfo(getApiInfo());
			return build;
		} catch (Exception e) {
			log.error("Error building custom Docket Bean. Resorting to default impelementation.");
			return build;
		}
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact(name, url, email);
		return new ApiInfo(basePackage, title, description, version, contact, license, licenseUrl,
				Collections.emptyList());

	}

}