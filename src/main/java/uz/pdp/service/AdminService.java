package uz.pdp.service;

import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;

import static uz.pdp.repository.AdminRepository.admin;
import static uz.pdp.util.Utilities.scanner;
import static uz.pdp.util.Utilities.strScanner;

public class AdminService {
    static UserRepository userRepository = new UserRepository();
    static User user = new User();

    public boolean checkAdminLogin() {
        System.out.println("Enter your phone number: ");
        String phoneNumber = strScanner.nextLine();
        System.out.println("Enter your password: ");
        String password = strScanner.nextLine();
        if (phoneNumber.equals(admin.getAdminPhoneNumber()) && password.equals(admin.getAdminPassword())) {
            System.out.println("Successfully completed!");
            return true;
        }
        System.out.println("We couldn't find your admin account!");
        return false;
    }

    public void showBalance() {
        System.out.println("Balance: " + admin.getAdminBalance() + "$");
    }

    public void blockUsers() {
        System.out.println("Enter user's phone number: ");
        String phoneNumber = scanner.nextLine();
        if (userRepository.isExist(phoneNumber)) {
            user.setIsBlocked(true);
            System.out.println("Done!");
        }
    }

    public void unblockUsers() {
        System.out.println("Enter user's phone number: ");
        String phoneNumber = scanner.nextLine();
        if (userRepository.isExist(phoneNumber)) {
            user.setIsBlocked(false);
            System.out.println("Done!");
        }
    }
}
