package com.leomarqz;

import com.leomarqz.data.UserJDBC;
import com.leomarqz.domain.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserJDBC usrDB = new UserJDBC();
//        int inserts = usrDB.insert(new User("Karla", "Hernandez", "khernandez@gmail.com", "9884089"));
//        System.out.println("inserts = " + inserts);
//        int updates = usrDB.update(new User(4, "Kelly", "Joya", "kjoya@gmail.com", "3546367"));
//        System.out.println("updates = " + updates);
//        int deleted = usrDB.delete(new User(4));
//        System.out.println("deleted = " + deleted);
        var data = usrDB.select();

        data.forEach((usr)->{
            System.out.println("usr = " + usr);
        });
    }
}