package uz.pdp.entity;

import lombok.Data;

@Data
public class Message {
    private String fromID;
    private String toID;
    private String text;
}
