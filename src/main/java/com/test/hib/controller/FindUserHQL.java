package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FindUserHQL {

    public void findUser() {
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
}
