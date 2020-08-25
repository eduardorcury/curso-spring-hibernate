# Módulo 6: Spring Security

## Configuração do MVC

```java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.erc.springdemo")
public class DemoAppConfig {

	// bean para o View Resolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");		
		return viewResolver;	
	}
}

```