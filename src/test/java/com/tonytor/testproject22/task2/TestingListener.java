package com.tonytor.testproject22.task2;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestingListener implements ISuiteListener {
    public static boolean start = false;

    public static boolean finish = false;

    @Override
    public void onFinish(ISuite arg0) {
        System.out.println("Finishing");
    }

    @Override
    public void onStart(ISuite arg0) {
        System.out.println("Starting");
    }

}
