package org.example;

public class LoginValidator {
    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException("Длина login должна быть меньше 20 символов.");
            }

            if (password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Длина password должна быть меньше 20 символов и пароли должны совпадать.");
            }

            return true;
        } catch (WrongLoginException e) {
            System.err.println("Ошибка валидации логина: " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.err.println("Ошибка валидации пароля: " + e.getMessage());
            return false;
        }
    }
}


