package com.eventos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jeferson
 * Classe responsável por configurar os atributos do Swagger
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket getDetalhes() {
		
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		
		docket
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.eventos"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(this.getInformacoesAPI().build());
		
		return docket;
	}
	
	private ApiInfoBuilder getInformacoesAPI() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("API Sistema Eventos");
		apiInfoBuilder.description("API Destinada ao estudo de Web Services Rest.");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("https://github.com/Jeferson-Oliveira/");
		apiInfoBuilder.contact(this.getContato());
 
		return apiInfoBuilder;
 
	}
	private Contact getContato() {
 
		return new Contact(
				"Jeferson Jesus",
				"https://github.com/Jeferson-Oliveira/", 
				"jefersonoliver7@gmail.com");
	}
}
