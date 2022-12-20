package uz.pdp.controller;

import uz.pdp.entity.User;
import uz.pdp.service.UserService;

import static uz.pdp.util.Utilities.scanner;

public class UserController {
    static UserService userService = new UserService();

    public void userMenu(User user) {
        String userMenu = """
                0. back to menu
                1. send message
                2. chat history
                3. delete chat
                4. block user
                5. unblock user
                6. delete account
                """;
        while (true) {
            System.out.println(userMenu);
            switch (scanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> userService.sendMessage();
                case 2 -> userService.chatHistory();
                case 3 -> userService.deleteChat();
                case 4 -> userService.blockUser(user);
                case 5 -> userService.unblockUser(user);
                case 6 -> {
                    userService.deleteAccount(user);
                    return;
                }
                default -> System.out.println("Something went wrong!");
            }
        }
    }
}
