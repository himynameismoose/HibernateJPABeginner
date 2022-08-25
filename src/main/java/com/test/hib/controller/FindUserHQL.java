package com.test.hib.controller;

import com.test.hib.model.User;
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
}
