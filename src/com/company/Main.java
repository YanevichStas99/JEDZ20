package com.company;

public class Main {

    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage("fileStorage1.txt");
        User user1 = new User("Alex",20);
        fileStorage.addUser(user1);
        User user2=new User("Dave",35);
        fileStorage.addUser(user2);
        User user3=fileStorage.getUser(2);
        System.out.println(user3);
        User user4=new User("Gary",49);
        fileStorage.addUser(user4);
        user4.setAge(42);
        user4.setName("Carl");
        fileStorage.updateUser(user4);
        System.out.println(fileStorage.getAllUsers());
        fileStorage.removeUser(1);
        System.out.println(fileStorage.getAllUsers());
        fileStorage.removeUserByName("Carl");
        System.out.println(fileStorage.getAllUsers());
        fileStorage.removeAll();

    }
}
