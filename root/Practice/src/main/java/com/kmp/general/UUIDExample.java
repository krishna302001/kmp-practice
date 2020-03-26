package com.kmp.general;

import java.util.UUID;

public class UUIDExample {
    public static void main(String[] args) {
        UUID uuid  = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(Long.MAX_VALUE);
//        2147483647
//        9223372036854775807
    }
}
