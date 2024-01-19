package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;


import com.model.Employee;
import com.util.HBUtil;

public class App {
	public static void main(String[] args) {
		Session session = HBUtil.sf.openSession();
		Transaction tx = session.beginTransaction();

		//"---------------------------------HQL QUERIES-------------------------------------------"
		
//		Query<Employee> q = session.createQuery("From Employee",Employee.class); // alt + shift + L fro creating query object
//		List<Employee> list = q.list();
//		for(Employee e: list)
//		{
//			System.out.println(e);
//		}

//		for(int i=1;i<=5000;i++)
//		{
//			Employee e = new Employee();
//			StringBuilder name= new StringBuilder();
//			for(int j=1;j<=15;j++)
//			name.append((char)(new Random().nextInt(26)+65));
//			e.setEname(name.toString());
//			
//			StringBuilder company= new StringBuilder();
//			for(int j=1;j<=15;j++)
//				company.append((char)(new Random().nextInt(26)+65));
//			e.setEcompany(company.toString());
//			
//			StringBuilder designation= new StringBuilder();
//			for(int j=1;j<=15;j++)
//				designation.append((char)(new Random().nextInt(26)+65));
//			e.setEdesignation(designation.toString());
//			
//			e.setEsalary(new Random().nextDouble()*100000);
//			session.save(e);
		// }

		// session.createQuery("from
		// Employee",Employee.class).list().forEach(e->System.out.println(e)); // fetch
		// all emp using list()method
		//Query<Employee> q = session.createQuery("from Employee where eid=:a", Employee.class);// fetch all emp using
																								// list()method
//		List<Employee> list = q.list();
//		for(Employee e:list)
//			System.out.println(e);
		//q.setParameter("a", 15);
//		Employee e = q.uniqueResult(); // can used for display single object
//
//		System.out.println(e);
		
//		Query q = session.createQuery("delete from Employee where eid=:a");
//		q.setParameter("a", 2);
//		int check=q.executeUpdate(); // ExecuteUpdate the query
//		System.out.println(check);
		
		//Query<Employee> q = session.createQuery("from Employee",Employee.class);
		//q.setMaxResults(10);//Set the limit to query
		//q.setFirstResult(10);//Set first result
		//q.setMaxResults(10).list();
//		List<Employee> list = q.list();
//		for(Employee e:list)
//			System.out.println(e);
		
		
		//method chaining display all empoyee
		//session.createQuery("from Employee",Employee.class).list().forEach(e->System.out.println(e)); 
		
		//Display employee by ID
		/*Query<Employee> q = session.createQuery("from Employee where eid=:a",Employee.class);
		q.setParameter("a", 23);
		Employee e= q.uniqueResult();
		System.out.println(e);
		
		
		OR
		
		Employee e= session.createQuery("from Employee where eid=:a",Employee.class).setParameter("a", 12).uniqueResult();
		System.out.println(e);
		*/
		
		
		//Display Employee by ID and Name
		
		/*Query<Employee> q = session.createQuery("from Employee where eid=:a and ename=:b",Employee.class);
		q.setParameter("a", 1);
		q.setParameter("b","FHJTJPXDINKSJGY" );
		Employee e= q.uniqueResult();
		
		Employee e = (Employee) session.createQuery("from Employee where eid=:a and ename=:b",Employee.class)
				.setParameter("a", 12)
				.setParameter("b", "PJNQZQQNKOTVRUF")
				.uniqueResult();
	       */
		
		//Display Employee by ID or Name
		/*
		Query<Employee> q = session.createQuery("from Employee where eid=:a or ename=:b",Employee.class);
		q.setParameter("a", 12);
		q.setParameter("b", "PJNQZQQNKOTVRUF");
		Employee e=q.uniqueResult();
		*/
//		Employee e =  session.createQuery("from Employee where eid=:a or ename=:b",Employee.class)
//				.setParameter("a", 23)
//				.setParameter("b", "LDOQPYUYBRGJUXS").list().forEach(e->System.out.println(e));
		
		//System.out.println(e);
		
		//Display First 20 Employee
		/*Query<Employee> q = session.createQuery("from Employee",Employee.class);
		q.setMaxResults(20);
		List<Employee> list = q.list();
		for(Employee e:list)
			System.out.println(e);
		
		OR
		
		session.createQuery("from Employee",Employee.class)
		.setMaxResults(20)
		.list().forEach(e->System.out.println(e));
		*/
		
		//Display skip first 10 employee
		
		/*List<Employee> list = session.createQuery("from Employee",Employee.class).setFirstResult(10).setMaxResults(10).list();
		for(Employee e:list)
			System.out.println(e);
			*/
		
		//Paging
		
		/*int page=1;
		int max=10;
		while(true)
		{
			List<Employee> list = session.createQuery("from Employee",Employee.class).setMaxResults(max)
					.setFirstResult((page-1)*max).list();
			if(list.isEmpty())
				break;
			System.out.println("Page number"+ page++);
			for(Employee e:list)
				System.out.println(e);
			System.out.println("-----------------------------------");
		}
		*/
//		Query<Employee> q = session.createNamedQuery("findAllEmployee",Employee.class);
//		List<Employee> list = q.list();
//		for(Employee e:list)
//			System.out.println(e);
//		tx.commit();
//		session.close();
		
		
		//"-------------------------------------HCQL---------------------------------------------------"
		
		//Display all employee by ID
		/*List<Employee> list = session.createCriteria(Employee.class).list();
		for(Employee e:list)
			System.out.println(e);*/
		
		//Display employee by ID
		
		/*Employee e=(Employee)session.createCriteria(Employee.class).add(Restrictions.eq("eid",22)).uniqueResult();
		System.out.println(e);*/
		
		// DIsplay employee by ID and Name
		/*Employee e= (Employee) session.createCriteria(Employee.class).add(Restrictions.eq("eid", 23))
				.add(Restrictions.eq("ename", "LDOQPYUYBRGJUXS")).uniqueResult();*/
		
		//Display employee  by ID or Name
		 /*List<Employee> list = session.createCriteria(Employee.class).add(Restrictions.or(Restrictions.eq("eid", 23))
				 .add(Restrictions.eq("ename", "HCSZKYXQBTZXMML")))
				 .list();
		 for(Employee e:list)
			 System.out.println(e);*/
		
		//Display employee  by ID or Name or company
		/*List<Employee> list = session.createCriteria(Employee.class).add(Restrictions.or(Restrictions.eq("eid", 23))
				.add(Restrictions.eq("ename", "HCSZKYXQBTZXMML")).add(Restrictions.eq("ecompany", "HUYENRNLMUUEPJT")))
				.list();
		for(Employee e:list)
			
		System.out.println(e);*/
		
		//Display Employee by salary less than
		
		/*List<Employee> list=session.createCriteria(Employee.class).add(Restrictions.lt("esalary", 100000.0)).list();
		for(Employee e:list)
			System.out.println(e);*/
		
		//Display Employee salary greater than 
		
		/*List<Employee>list=session.createCriteria(Employee.class).add(Restrictions.gt("esalary", 10000.0)).list();
		for(Employee e:list)
			System.out.println(e);*/
		
		//Disaplay Employee by salary between
		/*List <Employee> list=session.createCriteria(Employee.class).add(Restrictions.between("esalary", 10000.0, 50000.0)).list();
		for(Employee e:list)
			System.out.println(e);*/
		
		//Display Employee by  salary not between 
		/*List<Employee> list = session.createCriteria(Employee.class)
				.add(Restrictions.not(Restrictions.between("esalary", 10000.0, 50000.0))).list();
		for(Employee e:list)
			System.out.println(e);*/
		
		//Display Employee by ename like operator
		
		/*List<Employee> list =session.createCriteria(Employee.class).add(Restrictions.like("ename", "%S")).list();
		for(Employee e:list)
			System.out.println(e);*/
		
		//Dispaly Employee by eid IN operator
		/*List<Integer>id = new ArrayList();
		id.add(2);
		id.add(23);
		id.add(56);
		id.add(556);
		id.add(788);
		List<Employee>list=session.createCriteria(Employee.class).add(Restrictions.in("eid", id)).list();
		for(Employee e:list)
			System.out.println(e);*/
		
		//Display Employee by ename asc order
		
		/*List<Employee> list =session.createCriteria(Employee.class).addOrder(Order.asc("ename")).list();
		for(Employee e:list)
			System.out.println(e);*/
		
		//Display Employee by ename using Projection Method
		
		/*List<String> list = session.createCriteria(Employee.class)
		        .setProjection(Projections.property("ename"))
		        .list();*/

		List <String> list = session.createCriteria(Employee.class).setProjection(Projections.property("ename")).list();
		for (String s : list)
		    System.out.println(s);

		
		
		
		tx.commit();
		session.close();
	}
}
