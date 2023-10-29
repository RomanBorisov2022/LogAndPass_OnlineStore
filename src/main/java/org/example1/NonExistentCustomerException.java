package org.example1;

public class NonExistentCustomerException extends Exception {
    public NonExistentCustomerException() {
        super("Non-existent customer");
    }
}

