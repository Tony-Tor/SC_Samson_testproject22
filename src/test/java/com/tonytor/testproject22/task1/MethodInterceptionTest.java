package com.tonytor.testproject22.task1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

public class MethodInterceptionTest {

    @Test
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(".//*[@test-attr='button_search']", mainPage.buttonSearch());
        assertEquals(".//*[@test-attr='input_search']", mainPage.textInputSearch());
    }

    private MainPage createPage(Class clazz) {
        return (MainPage) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{MainPage.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return getString(method.getName());
            }

            public String getString(String method1) throws NoSuchMethodException {
                return ((Selector) clazz.getMethod(method1).getAnnotation(Selector.class)).xpath();
            }
        });
    }
}
