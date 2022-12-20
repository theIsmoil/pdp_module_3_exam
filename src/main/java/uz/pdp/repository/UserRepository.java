package uz.pdp.repository;

import com.google.gson.reflect.TypeToken;
import uz.pdp.entity.User;
import uz.pdp.util.Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    String usersDir = "D:\\#pdp\\Java\\exam3\\Messenger Project\\src\\main\\resources\\Users.json";

    public void addUser(User user) {
        List<User> users = getAllUsers();
        users.add(user);
        writeUsers(users);
    }

    public void writeUsers(List<User> users) {
        new Thread(() -> {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(usersDir));
                writer.write(Utilities.gson.toJson(users));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    public boolean isExist(String phoneNumber) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (Objects.equals(user.getPhoneNumber(), phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            users = Utilities.gson.fromJson(new FileReader(usersDir), new TypeToken<ArrayList<User>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users == null ? new ArrayList<>() : users;
    }

    public User getUser(String phoneNumber, String password) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (Objects.equals(user.getPhoneNumber(), phoneNumber) &&
                    Objects.equals(user.getPassword(), password)) {
                return user;
            }
        }
        return null;
    }

}
