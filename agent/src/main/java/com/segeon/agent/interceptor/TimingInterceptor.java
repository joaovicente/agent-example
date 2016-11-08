package com.segeon.agent.interceptor;

import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.Origin;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * Created by vicentejo on 08/11/2016.
 */
public class TimingInterceptor {
    @RuntimeType
    public static Object intercept(@Origin Method method,
                                   @SuperCall Callable<?> callable) {
        System.out.println("Intercepted before " + method + " " + System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "]");
//        long start = System.currentTimeMillis();
        try {
            return callable.call();
        }
          catch (Exception e)  {
        } finally {
            System.out.println("Intercepted after  " + method + " " + System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "]");
        }
        return null;
    }
}
