package com.jktek25.app;

/**
 * Hello World application.
 * The main class for the application.
 */
public final class Main {
    /**
     * The main method for the application.
     * @param args The command-line arguments.
     */
    public static void main(final String[] args) {
        System.out.println("Hello world!!!");
    }

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private Main() {
        throw new UnsupportedOperationException(
            "This is a utility class and cannot be instantiated");
    }
}
