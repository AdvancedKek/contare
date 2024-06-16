package io.github.kozinaki;

import io.github.kozinaki.infrastructure.postgres.UserProviderImpl;

public class Main {
    public static void main(String[] args) {
        UserProviderImpl impl = new UserProviderImpl();
        System.out.println("Hello world!");
    }
}