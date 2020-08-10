# Módulo 2: Spring MVC

## Controllers

```java
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
		
	}
}
```

## Views

```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer registration form</title>
	<style>
		.error {color:red}
	</style>
</head>

<body>
<i>Fill out the form.</i>
<br><br>
	<form:form action="processForm" modelAttribute="customer">
  
	  First Name: <form:input path="firstName"/>
	  <br><br>
    
	  Last Name (*): <form:input path="lastName"/>
	  <form:errors path="lastName" cssClass="error"></form:errors>
	  <br><br>
	
    Free passes: <form:input path="freePasses"/>
	  <form:errors path="freePasses" cssClass="error"></form:errors>
	  <br><br>
    
	  Postal code: <form:input path="postalCode"/>
	  <form:errors path="postalCode" cssClass="error"></form:errors>
	  <br><br>
    
	  Course code: <form:input path="courseCode"/>
	  <form:errors path="courseCode" cssClass="error"></form:errors>
	  <br><br>
    
	  <input type="submit" value="Submit" />
    
	</form:form>
</body>
</html>
```
## Criando anotações customizadas

#### @interface

```java
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	// campo "value"
	public String value() default "LUV";
	
	// campo "message"
	public String message() default "deve começar com LUV";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};

}
```

#### Validator

```java
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

  // regra de validação
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

		boolean result;
		
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
		}
		else {
			return true;
		}
		
		return result;
	}

}
```
