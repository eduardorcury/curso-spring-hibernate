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

## Configuração do Spring Security

- Adicionando página de login e logout:

```java
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll();
	}
}
```

- Adicionando roles e página de acesso negado
```java
@Override
protected void configure(HttpSecurity http) throws Exception {

	http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
		
}
```