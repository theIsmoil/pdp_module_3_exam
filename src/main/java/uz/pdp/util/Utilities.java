package uz.pdp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public interface Utilities {
    Scanner scanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
}
