package com.tonytor.testproject22.task2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.*;

@Listeners(TestingListener.class)
@TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
public class Tests {

    @Test
    public void annotation() {
        TestMethodInfo testMethodInfo = Tests.class.getAnnotation(TestMethodInfo.class);
        System.out.println(String.format(Locale.ENGLISH,
                "Priority = %s, Author = \"%s\", LastModified = %s",
                testMethodInfo.priority(),
                testMethodInfo.author(),
                testMethodInfo.lastModified()));
        assertEquals(1, 1);
    }
}
