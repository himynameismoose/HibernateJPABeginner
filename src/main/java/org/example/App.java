package org.example;

import com.perscholas.model.Department2;
import com.perscholas.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main( String[] args ) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Teacher teacher1 = new Teacher();
        teacher1.setTeacherName("Haseeb");
        teacher1.setSalary("100");

        Teacher teacher2 = new Teacher();
        teacher2.setTeacherName("Jenny Finch");
        teacher2.setSalary("10000");

        Teacher teacher3 = new Teacher();
        teacher3.setTeacherName("James");
        teacher3.setSalary("25000");

        Teacher teacher4 = new Teacher();
        teacher4.setTeacherName("SID ROSE");
        teacher4.setSalary("3000");

        Teacher teacher5 = new Teacher();
        teacher5.setSalary("200");
        teacher5.setTeacherName("Ali");

        // Add teacher entity object to the list
        List<Teacher> teacherList = new ArrayList();
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        teacherList.add(teacher3);
        teacherList.add(teacher4);
        teacherList.add(teacher5);

        session.persist(teacher1);
        session.persist(teacher2);
        session.persist(teacher3);
        session.persist(teacher4);
        session.persist(teacher5);

        // Create Department
        Department2 department = new Department2();
        department.setDname("Development");
        department.setTeacherList(teacherList);

        // Store Department
        session.persist(department);

        t.commit();
    }
}
