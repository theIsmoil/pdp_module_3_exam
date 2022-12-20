package uz.pdp.controller;

import uz.pdp.service.MainService;

import static uz.pdp.util.Utilities.scanner;

public class MainController {
    static MainService mainService = new MainService();
    public void mainController() {
        String mainMenu = """        
                *  Messenger App
                0. Exit
                1. User
                2. Admin
                """;
        while (true) {
            System.out.println(mainMenu);
            switch (scanner.nextInt()) {
                case 0 -> {
                    System.out.println("Good bye!");
                    return;
                }
                case 1 -> mainService.userLogIn();
                case 2 -> mainService.adminLogIn();
                default -> System.out.println("Something went wrong!");
            }
        }
    }
}
