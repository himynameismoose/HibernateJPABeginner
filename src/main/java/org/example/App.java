package org.example;

import com.perscholas.model.Department2;
import com.perscholas.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main( String[] args ) {


//        FindUserHQL user = new FindUserHQL();
//        user.findUser();
//        user.findUserSelect();
//        user.getRecordById();
//        user.getMaxSalary();
//        user.getUserCount();
//        user.namedQueryExample();

//        EmployeeController e = new EmployeeController();
//        e.createEmployeeTable();
//        e.findEmployeeByName();
//        e.findEmployeeById();
//        e.showOfficeCodesAsDepartment();

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Department2 department1 = new Department2();
        department1.setDname("IT");

        Department2 department2 = new Department2();
        department2.setDname("HR");

        Teacher teacher1 = new Teacher();
        teacher1.setDepartment(department1);
        teacher1.setSalary("1000");
        teacher1.setTeacherName("MHaseeb");

        Teacher teacher2 = new Teacher();
        teacher2.setDepartment(department1);
        teacher2.setSalary("2220");
        teacher2.setTeacherName("Shahparan");

        Teacher teacher3 = new Teacher();
        teacher3.setDepartment(department1);
        teacher3.setSalary("30000");
        teacher3.setTeacherName("James");

        Teacher teacher4 = new Teacher();
        teacher4.setDepartment(department2);
        teacher4.setSalary("40000");
        teacher4.setTeacherName("Joseph");

        session.persist(department1);
        session.persist(department2);
        session.persist(teacher1);
        session.persist(teacher2);
        session.persist(teacher3);
        session.persist(teacher4);

        t.commit();
    }
}
