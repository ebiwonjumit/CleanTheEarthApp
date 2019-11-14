package com.software.cleantheearthapp;

import org.junit.Test;

import static org.junit.Assert.*;

import com.software.cleantheearthapp.LoginPageActivity;

public class LoginTest {

   private LoginPageActivity loginPageActivity;

    @Test
    public void inputUsername(){
        assertEquals("test", loginPageActivity.getUsername());
    }

    @Test
    public void inputPassword(){
        assertEquals("testpassword",loginPageActivity.getPassword());
    }
}
