package com.zhusq.proxy.jdkproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

    public static void main(String[] args) throws Exception {
        //这里有两种写法，我们采用略微复杂的一种写法，这样更有助于大家理解。
        Class<?> proxyClass = Proxy.getProxyClass(JdkProxyTest.class.getClassLoader(), HelloWorld.class);
        final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
        final InvocationHandler ih = new MyInvocationHandler(new HelloWorldImpl());
        HelloWorld helloWorld = (HelloWorld) cons.newInstance(ih);

        /**
         * 另一种简便的创建方法
         helloWorld = (HelloWorld) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(),
                 new Class<?>[]{HelloWorld.class},
                 new MyInvocationHandler(new HelloWorldImpl()));
         */

        helloWorld.say();
        helloWorld.say2();
    }
}
