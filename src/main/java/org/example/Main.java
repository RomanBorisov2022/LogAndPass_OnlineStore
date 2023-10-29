package org.example;

import static org.example.LoginValidator.validate;

public class Main {
    public static void main(String[] args) {
        String login = "myusername";
        String password = "mypassword";
        String confirmPassword = "mypassword";

        if (validate(login, password, confirmPassword)) {
            System.out.println("Регистрация успешна.");
        } else {
            System.out.println("Регистрация не удалась.");
        }
    }
}