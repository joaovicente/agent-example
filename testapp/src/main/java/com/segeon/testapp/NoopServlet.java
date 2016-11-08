package com.segeon.testapp;

/**
 * Created by vicentejo on 08/11/2016.
 */
public class NoopServlet {
    public void methodA()    {
        try {
            System.out.println("Inline before NoopServlet.methodA() " + System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "]");
            Thread.sleep(100);
            System.out.println("Inline after NoopServlet.methodA()  " + System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void methodB()    {
        try {
            System.out.println("Inline before NoopServlet.methodB() " + System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "]");
            Thread.sleep(100);
            System.out.println("Inline after NoopServlet.methodB()  " + System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
