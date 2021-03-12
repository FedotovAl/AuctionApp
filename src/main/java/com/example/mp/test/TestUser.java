package com.example.mp.test;

import com.example.mp.entity.User;

public class TestUser {
    public static Long id = 1L;
    public static boolean isLogin = true;

    public static void login(User user){
        id = user.getId();
    }

    public static void logout(){
        id = null;
    }
}
