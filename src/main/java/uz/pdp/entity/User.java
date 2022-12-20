package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userID = UUID.randomUUID().toString();
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;
    private Double balance;
    private Boolean isBlocked = false;
}
