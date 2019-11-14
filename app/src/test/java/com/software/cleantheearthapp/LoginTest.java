package com.software.cleantheearthapp;

import org.junit.Test;

import static org.junit.Assert.*;

import com.software.cleantheearthapp.LoginPageActivity;

public class LoginTest {

   private LoginPageActivity loginPageActivity;

    @Test
    public void inputUsername(){
        assertEquals("testUser1", loginPageActivity.getUsername());
    }

    @Test
    public void inputPassword(){
        assertEquals("testUser1Pass",loginPageActivity.getPassword());
    }
}
