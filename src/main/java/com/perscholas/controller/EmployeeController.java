package com.perscholas.controller;

import com.perscholas.model.Employee;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeController {

    public void createEmployeeTable() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee employee = new Employee();

        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

    public void findEmployeeByName() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Use Hibernate Name Query
        Query<Employee> query = session.createNamedQuery("findEmployeeByName", Employee.class);
        query.setParameter("name", "Tom Thele");
        List<Employee> results = query.getResultList();
        for (Employee e : results) {
            System.out.println(e);
        }

        factory.close();
        session.close();
    }

    public void findEmployeeById() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        TypedQuery<Object[]> query = session.createNamedQuery("get_emp_name_by_id", Object[].class);
        query.setParameter("id", 3);
        List<Object[]> employee = query.getResultList();

        for (Object[] e : employee) {
            System.out.println("Employee Name: " + e[0] + " | " +
                               "Employee Salary: " + e[1] + " | " +
                               "Employee Job Title: " + e[2]);
        }

        factory.close();
        session.close();
    }
}
