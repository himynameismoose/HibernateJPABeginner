package com.test.hib.controller;

import com.test.hib.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateDepartment {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Department dept1 = new Department();
        dept1.setName("HR");
        dept1.setState("Georgia");

        Department dept2 = new Department();
        dept2.setName("Finance");
        dept2.setState("Florida");

        Department dept3 = new Department();
        dept3.setName("Shipping");
        dept3.setState("North Carolina");

        Department dept4 = new Department("Technology", "New York");

        session.persist(dept1);
        session.persist(dept2);
        session.persist(dept3);
        session.persist(dept4);

        t.commit();
        System.out.println("Department successfully saved!");

        factory.close();
        session.close();
    }
}
