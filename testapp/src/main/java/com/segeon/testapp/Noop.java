package com.segeon.testapp;

/**
 * Created by vicentejo on 08/11/2016.
 */
public class Noop {
    public void perform()    {
        try {
            System.out.println("Inline before Noop.perform() " + System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "]");
            Thread.sleep(100);
            System.out.println("Inline after Noop.perform()  " + System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
