package uz.pdp.service;

import uz.pdp.entity.Message;
import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;

import static uz.pdp.util.Utilities.strScanner;

public class MessageService {
    static UserRepository userRepository = new UserRepository();
    static Message message = new Message();
    static User user = new User();

    public void sendMessage() {

    }
}
