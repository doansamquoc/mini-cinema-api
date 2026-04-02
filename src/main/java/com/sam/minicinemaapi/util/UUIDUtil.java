package com.sam.minicinemaapi.util;

public class UUIDUtil {
    public static String generate() {
        return Long.toString(System.currentTimeMillis(), 36).substring(0, 8);
    }
}
