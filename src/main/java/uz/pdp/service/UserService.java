package uz.pdp.service;

import uz.pdp.controller.UserController;
import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;

import java.util.List;
import java.util.Objects;

import static uz.pdp.util.Utilities.scanner;
import static uz.pdp.util.Utilities.strScanner;

public class UserService {
    static User user = new User();
    static UserRepository userRepository = new UserRepository();
    static UserController userController = new UserController();
    static MessageService messageService = new MessageService();

    public void signIn() {
        System.out.print(" - phone number: ");
        String phoneNumber = strScanner.nextLine();

        System.out.print(" - password: ");
        String password = strScanner.nextLine();

        User user = userRepository.getUser(phoneNumber, password);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        userController.userMenu(user);
    }

    public void signUp() {
        User user = new User();
        System.out.println("Register process: ");
        System.out.print(" - name: ");
        String name = strScanner.nextLine();
        user.setName(name);
        System.out.print(" - surname: ");
        String surname = strScanner.nextLine();
        user.setSurname(surname);

        System.out.print(" - phone number: ");
        String phoneNumber = strScanner.nextLine();
        user.setPhoneNumber(phoneNumber);
        if (userRepository.isExist(phoneNumber)) {
            System.out.println("This number is already registered!");
            return;
        }

        System.out.print(" - password: ");
        String password = strScanner.nextLine();
        if (password.length() >= 8) {
            user.setPassword(password);
        } else {
            System.out.println("Something went wrong!");
        }

        System.out.print(" - balance: ");
        Double balance = scanner.nextDouble();
        if (balance >= 0) {
            user.setBalance(balance);
        } else {
            System.out.println("Something went wrong!");
        }

        userRepository.addUser(user);
        System.out.println("Successfully completed!");
    }

    public void sendMessage() {
        messageService.sendMessage();
    }

    public void chatHistory() {

    }

    public void deleteChat() {

    }

    public void blockUser(User user) {
        System.out.print("Enter user phone number: ");
        String phoneNumber = strScanner.nextLine();
        if (userRepository.isExist(phoneNumber)) {
            user.setIsBlocked(true);
            System.out.println("Done!");
        } else {
            System.out.println("We couldn't find this number!");
        }
    }
    public void unblockUser(User user) {
        System.out.print("Enter user phone number: ");
        String phoneNumber = strScanner.nextLine();
        if (userRepository.isExist(phoneNumber)) {
            user.setIsBlocked(false);
            System.out.println("Done!");
        } else {
            System.out.println("We couldn't find this number!");
        }
    }
    public void deleteAccount(User user) {
        for (int i = 0; i < userRepository.getAllUsers().size(); i++) {
            if (Objects.equals(userRepository.getAllUsers().get(i).getUserID(), user.getUserID())) {
                List<User> users = userRepository.getAllUsers();
                users.remove(i);
                userRepository.writeUsers(users);
                System.out.println("Account successfully deleted!");
                return;
            }
        }
    }
}
