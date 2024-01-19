package com.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Gift;
import com.model.Student;
import com.util.HBUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Session session = HBUtils.sf.openSession();
		Transaction tx = session.beginTransaction();
		/* give sid to lid............ */
//       Student s1=session.get(Student.class, 2);
//       Laptop l1=session.get(Laptop.class, 2);
//       s1.setLaptop(l1);
//       l1.setStudent(s1);

		// ONE TO ONE Relation

		/*
		 * Student s1 = session.get(Student.class, 5); System.out.println(s1);
		 * System.out.println(s1.getLaptop()); System.out.println(s1.getSname());
		 */

		// ONE TO MANY Relation
//       Gift g = new Gift();
//       g.setGname("bottle");
//       g.setGtype("home");
//       session.save(g);

		// Add gift to student

		/*
		 * int a[]= {3,10,24}; for(int i=0;i<a.length;i++) { Student
		 * s=session.get(Student.class, 8); Gift g = session.get(Gift.class, a[i]);
		 * g.setStudent(s); }
		 */

		// fetch information about student

		//Student s = session.get(Student.class, 8);
		Gift g=session.get(Gift.class, 18);
		System.out.println(g);
		System.out.println(g.getStudent().getLaptop().getLname());
		
//		for (Gift g : s.getGifts())
//			System.out.println(g);
//		System.out.println(s.getScity());
		System.out.println();
		tx.commit();
		session.close();
	}
}
