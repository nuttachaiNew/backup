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
