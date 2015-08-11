/* Example for define Datasource */

	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		        <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
		        <property name="url" value="jdbc:oracle:thin:@172.16.0.32:1521:TWCMT1"/>
		        <property name="username" value="SCOTT"/>
		        <property name="password" value="TIGER"/>
	</bean>
	
/* How to use properties from properties file*/
[in database.properties]
database.url=jdbc:oracle:thin:@172.16.0.32:1521:TWCMT1

[in springapp-context.xml when load from properties file]
 <property name="url" value="${database.url}"/>

 
 /* Example for define SessionFactory */
 <bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
			<property name="dataSource" ref="dataSource" />
			<property name="mappingResources">
				<list>
           			<value>com/ss/training/entity/Person.hbm.xml</value>
				</list>
      		</property>
			<property name="hibernateProperties">
				<props>
					<prop key="hibernate.dialect">${hibernate.dialect}</prop>
					<prop key="hibernate.show_sql">${hibernate.show_sql}</prop>
					<prop key="hibernate.format_sql">${hibernate.format_sql}</prop>
					<prop key="hibernate.hbm2ddl.auto">${hibernate.hbm2ddl.auto}</prop>
				</props>
			</property>
	</bean>