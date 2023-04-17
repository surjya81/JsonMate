package com.bluebird.jsonmate.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

//@SuppressWarnings("deprecation")
//@Configuration
//@EnableSwagger2WebMvc
//public class SwaggerConfig implements WebMvcConfigurer {

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Your API Title")
//                .description("Your API Description")
//                .version("1.0.0")
//                .build();
//    }
public class SwaggerConfig {
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("SpringShop API")
	              .description("Spring shop sample application")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("SpringShop Wiki Documentation")
	              .url("https://springshop.wiki.github.org/docs"));
//	 @Bean
//	  public GroupedOpenApi publicApi() {
//	      return GroupedOpenApi.builder()
//	              .group("springshop-public")
//	              .pathsToMatch("/public/**")
//	              .build();
//	  }
//	  @Bean
//	  public GroupedOpenApi adminApi() {
//	      return GroupedOpenApi.builder()
//	              .group("springshop-admin")
//	              .pathsToMatch("/admin/**")
//	              .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
//	              .build();
//	  }
	  }
}
