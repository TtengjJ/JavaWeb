package com.example.utils;

public class ThreatLocal {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void setCurrentId(String token){
        threadLocal.set(token);
    }
    public static String getCurrentId(){
        return threadLocal.get();
    }
    public static void remove(){
        threadLocal.remove();
    }
}
