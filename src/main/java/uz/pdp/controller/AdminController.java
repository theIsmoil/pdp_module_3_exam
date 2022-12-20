package uz.pdp.controller;

import uz.pdp.service.AdminService;

import static uz.pdp.util.Utilities.scanner;

public class AdminController {
    static AdminService adminService = new AdminService();
    public void adminMenu() {
        String adminMenyoo = """
                0. back to menu
                1. balance
                2. block users
                3. unblock users
                """;
        while (true) {
            System.out.println(adminMenyoo);
            switch (scanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> adminService.showBalance();
                case 2 -> adminService.blockUsers();
                case 3 -> adminService.unblockUsers();
                default -> System.out.println("Something went wrong!");
            }
        }
    }
}
