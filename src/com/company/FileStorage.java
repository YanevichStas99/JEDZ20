package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements Storage {
    private String filename;
    private List<User> users = new ArrayList<>();
    private int count = 1;


    public FileStorage(String filename) {
        this.filename = filename;
    }

    @Override
    public void removeAll() {
        users.clear();
        writeToFile();
    }

    @Override
    public void removeUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                break;
            }
        }
        writeToFile();
    }

    @Override
    public void removeUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                users.remove(user);
                break;
            }
        }
        writeToFile();
    }

    @Override
    public void addUser(User user) {
        user.setId(count);
        count++;
        users.add(user);
        writeToFile();

    }

    @Override
    public void updateUser(User userUpdated) {
        for (User user1 : users) {
            if (user1.getId() == userUpdated.getId()) {
               user1=userUpdated;
               break;
            }
        }
        writeToFile();
    }

    @Override
    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
    private void writeToFile(){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(users);
        try {
            FileUtils.writeStringToFile(new File(filename), json, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
