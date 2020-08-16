# Módulo 3: Projeto com MVC

## DAO - Data Access Object

- @Transaction - Elimina a necessidade de usar **commit()** na sessão do Hibernate.

```java
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// pegar sessão do hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// criar Query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		
		// executar Query
		List<Customer> customers = query.getResultList();
		
		// retornar lista de objetos
		return customers;
		
	}

}
```
- Bean SessionFactory criado com as propriedades do Hibernate:

```xml
<bean id="sessionFactory"
  class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
  <property name="dataSource" ref="myDataSource" />
  <property name="packagesToScan" value="com.erc.springdemo.entity" />
  <property name="hibernateProperties">
    <props>
      <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
      <prop key="hibernate.show_sql">true</prop>
    </props>
  </property>
</bean>	
```
