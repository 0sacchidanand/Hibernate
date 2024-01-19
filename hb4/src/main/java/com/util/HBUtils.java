package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Gift;
import com.model.Laptop;
import com.model.Student;

public class HBUtils {

	public static SessionFactory sf = new Configuration().setProperties(hbProperties()).addAnnotatedClass(Student.class)
			.addAnnotatedClass(Laptop.class).addAnnotatedClass(Gift.class).buildSessionFactory();

	private static Properties hbProperties() {
		Properties p = new Properties();
		/*
		 * ............................Set mysql Connection
		 * ............................................
		 */
		p.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		p.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/jap58");
		p.setProperty("hibernate.connection.username", "root");
		p.setProperty("hibernate.connection.password", "password");

		/*
		 * .................................Configuration...............................
		 * ....
		 */
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.format_sql", "true");

		return p;
	}

}
