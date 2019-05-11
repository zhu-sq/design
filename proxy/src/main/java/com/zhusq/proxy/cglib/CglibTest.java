package com.zhusq.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
     public static void main(String[] args){
         // 代理类class文件存入本地磁盘方便我们反编译查看源码
         System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,System.getProperty("user.dir"));

         Enhancer enhancer = new Enhancer();
         enhancer.setSuperclass(HelloWorld.class);
         enhancer.setCallback(new MyMethodInterceptor());
         HelloWorld helloWorld = (HelloWorld)enhancer.create();
         helloWorld.say();
         helloWorld.say2();
         helloWorld.sayByFinal();
     }
}
