package com.test.hib.controller;

import com.test.hib.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FindDepartment {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Department dept = session.get(Department.class, 4);

        System.out.println("Name of the department: " + dept.getName() +
                           " and State that the department is in: " + dept.getState());

        t.commit();
        factory.close();
        session.close();
    }
}
