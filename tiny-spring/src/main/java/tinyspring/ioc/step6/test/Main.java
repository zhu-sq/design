package tinyspring.ioc.step6.test;

import tinyspring.ioc.step6.context.ApplicationContext;
import tinyspring.ioc.step6.context.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("step6/beans.xml");
        TestBean testBean = (TestBean) applicationContext.getBean("testBean");
        testBean.hello();
    }
}
