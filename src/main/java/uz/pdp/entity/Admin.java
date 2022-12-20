package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private String adminID = UUID.randomUUID().toString();
    private String adminName;
    private String adminSurname;
    private String adminPhoneNumber;
    private String adminPassword;
    private Double adminBalance;
}
