package tinyspring.ioc.step2;


import tinyspring.ioc.step2.factory.AutoWriteBeanFactory;
import tinyspring.ioc.step2.factory.BeanFactory;

public class Main {

    public static void main(String[] args){

        //初始化beanFactory
        BeanFactory beanFactory = new AutoWriteBeanFactory();

        //实例化BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition();
       beanDefinition.setBeanName("tinyspring.ioc.step2.TestBean");

        beanFactory.registerBean("testBean",beanDefinition);

        //获取bean
        TestBean testBean = (TestBean) beanFactory.getBean("testBean");
        System.out.println(testBean);
    }
}
