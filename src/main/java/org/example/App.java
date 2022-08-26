package org.example;

import com.perscholas.controller.EmployeeController;
import com.test.hib.controller.FindUserHQL;

public class App {

    public static void main( String[] args ) {


//        FindUserHQL user = new FindUserHQL();
//        user.findUser();
//        user.findUserSelect();
//        user.getRecordById();
//        user.getMaxSalary();
//        user.getUserCount();
//        user.namedQueryExample();

        EmployeeController e = new EmployeeController();
//        e.createEmployeeTable();
//        e.findEmployeeByName();
//        e.findEmployeeById();
        e.showOfficeCodesAsDepartment();
    }
}
