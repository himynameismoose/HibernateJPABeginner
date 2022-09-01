package org.example;

import com.perscholas.model.Address;
import com.perscholas.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main( String[] args ) {
        System.out.println("Maven + Hibernate + SQL One to One Mapping Annotations");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Address address1 = new Address();
        address1.setCity("NYC");
        address1.setState("NY");
        address1.setStreet("27th Street");
        address1.setZipcode(11103);

        Address address2 = new Address();
        address2.setCity("Buffalo");
        address2.setState("NY");
        address2.setStreet("28th Street");
        address2.setZipcode(15803);

        Person person1 = new Person();
        person1.setAge(25);
        person1.setEmail("e.jon@email.com");
        person1.setName("Elbert Adam");
        person1.setAddress(address1);

        Person person2 = new Person();
        person2.setAge(45);
        person2.setEmail("ch.fink@email.com");
        person2.setName("Christ Fink");
        person2.setAddress(address2);

        session.persist(person1);
        session.persist(person2);
        session.persist(address1);
        session.persist(address2);

        t.commit();
    }
}
