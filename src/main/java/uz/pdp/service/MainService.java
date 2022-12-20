package uz.pdp.service;

import uz.pdp.controller.AdminController;

import static uz.pdp.util.Utilities.scanner;

public class MainService {
   static UserService userService = new UserService();
   static AdminService adminService = new AdminService();
   static AdminController adminController = new AdminController();

    public void userLogIn() {

        String userLoginMenu = """
                0. back to menu
                1. sign-in
                2. sign-up
                """;
        while (true) {
            System.out.println(userLoginMenu);
            switch (scanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> userService.signIn();
                case 2 -> userService.signUp();
                default -> System.out.println("Something went wrong!");
            }
        }
    }

    public void adminLogIn() {
        String adminLoginMenu = """
                0. back to menu
                1. login
                """;
        while (true) {
            System.out.println(adminLoginMenu);
            switch (scanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    if (adminService.checkAdminLogin()) {
                        adminController.adminMenu();
                    }
                }
                default -> System.out.println("Something went wrong!");
            }
        }
    }

}
