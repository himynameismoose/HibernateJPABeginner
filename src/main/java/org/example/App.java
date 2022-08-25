package org.example;

import com.test.hib.controller.FindUserHQL;

public class App {

    public static void main( String[] args ) {


        FindUserHQL user = new FindUserHQL();
//        user.findUser();
//        user.findUserSelect();
        user.getRecordById();
    }
}
