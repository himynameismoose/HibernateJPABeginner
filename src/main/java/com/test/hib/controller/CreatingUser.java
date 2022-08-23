package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreatingUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        User user1 = new User();
        user1.setEmail("haseeb@gmail.com");
        user1.setFullname("Moh Haseeb");
        user1.setPassword("has123");
        user1.setSalary(2000.69);
        user1.setAge(20);
        user1.setCity("NYC");

        User user2 = new User();
        user2.setEmail("James@gmail.com");
        user2.setFullname("James Santana");
        user2.setPassword("James123");
        user2.setSalary(2060.69);
        user2.setAge(25);
        user2.setCity("Dallas");

        User user3 = new User();
        user3.setEmail("Shahparan@gmail.com");
        user3.setFullname("AH Shahparan");
        user3.setPassword("Shahparan123");
        user3.setSalary(3060.69);
        user3.setAge(30);
        user3.setCity("Chicago");

        // Pass values/data using constructor
        User user4 = new User("Christ", "christ@gmail.com", "147852", 35, 35000.3, "NJ");
        User user5 = new User("Sid", "Sid", "s258", 29, 4000.36, "LA");

        Integer userid = null;

        // Save users to database
        session.persist(user1);
        session.persist(user2);
        session.persist(user3);
        session.persist(user4);
        session.persist(user5);

        t.commit();
        System.out.println("successfully saved");

        factory.close();
        session.close();
    }
}
