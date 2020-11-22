package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.controllers.HelloController;

import org.junit.jupiter.api.Test;

public class HelloControllerTests {
    @Test
    public void testSayHello() {
        assertEquals("Hello World",new HelloController().index());
    }
}
