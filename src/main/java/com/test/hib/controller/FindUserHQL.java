package com.test.hib.controller;

import com.test.hib.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FindUserHQL {

    public void findUser() { // Use the FROM clause
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM User";
        Query<User> query = session.createQuery(hql, User.class);
        List<User> results = query.getResultList();

        for (User user : results) {
            System.out.println(
                    "User Id: " + user.getId() + " | " +
                    "Full name: " + user.getFullname() + " | " +
                    "Email: " + user.getEmail() + " | " +
                    "Password: " + user.getPassword());
        }
    }

    public void findUserSelect() { // Use the SELECT clause
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Get all records using HQL
        String hql = "SELECT user FROM User user";
        Query<User> query = session.createQuery(hql, User.class);
        List<User> results = query.getResultList();

        for (User user : results) {
            System.out.println(
                    "User Id: " + user.getId() + " | " +
                            "Full name: " + user.getFullname() + " | " +
                            "Email: " + user.getEmail() + " | " +
                            "Password: " + user.getPassword());
        }
    }

    public void getRecordById() { // Use WHERE and ORDER BY
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT user " +
                "FROM User user " +
                "WHERE user.id < 5" +
                "ORDER BY user.id DESC";

        Query<User> query = session.createQuery(hql, User.class);
        List<User> results = query.getResultList();

        for (User user : results) {
            System.out.println(
                    "User Id: " + user.getId() + " | " +
                            "Full name: " + user.getFullname() + " | " +
                            "Email: " + user.getEmail() + " | " +
                            "Password: " + user.getPassword());
        }
    }

    public void getMaxSalary() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT MAX(user.salary) FROM User user";
        Query<Double> query = session.createQuery(hql, Double.class);
        double maxSalary = (Double) query.getSingleResult();

        System.out.println("Maximum Salary: " + maxSalary);
    }

    public void getUserCount() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT COUNT(*) FROM User user";
        List<User> results = session.createQuery(hql, User.class).getResultList();
        System.out.println(results);
    }

    public void namedQueryExample() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM User user WHERE user.id = :id";
        TypedQuery<User> query = session.createQuery(hql, User.class);
        query.setParameter("id", 2);
        List<User> results = query.getResultList();

        for (User user : results) {
            System.out.println(
                    "User Id: " + user.getId() + " | " +
                            "Full name: " + user.getFullname() + " | " +
                            "Email: " + user.getEmail() + " | " +
                            "Password: " + user.getPassword());
        }
    }
}
