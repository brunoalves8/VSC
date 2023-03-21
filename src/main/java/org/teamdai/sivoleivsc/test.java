package org.teamdai.sivoleivsc;


import BackEnd.ListOfUsers;

public class test {
    public static void main(String [] args){

        ListOfUsers userList = new ListOfUsers();


        userList.registerUser("user1", "password1", "user1@example.com");
        userList.registerUser("user2", "password2", "user2@example.com");


        System.out.println(userList.verifyuserexists("user1")); // true
        System.out.println(userList.verifyuserexists("user3")); // false


        System.out.println(userList.authenticate("user1", "password1")); // true
        System.out.println(userList.authenticate("user2", "password3")); // false
    }
    }
