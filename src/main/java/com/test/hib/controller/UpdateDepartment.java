package com.test.hib.controller;

import com.test.hib.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateDepartment {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Department dept = new Department();

        dept.setDid(2);
        dept.setName("Accounting");
        dept.setState("Georgia");

        session.merge(dept);
        session.getTransaction().commit();

        session.close();
    }
}
