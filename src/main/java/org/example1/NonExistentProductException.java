package org.example1;

public class NonExistentProductException extends Exception {
    public NonExistentProductException() {
        super("Non-existent product");
    }
}
