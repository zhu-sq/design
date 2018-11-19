package tinyspring.ioc.step1;

public class Main {

    public static void main(String[] args){

        //初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();

        //注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new TestBean("测试的bean呢"));
        beanFactory.addBean("testBean",beanDefinition);


        //获取bean
        TestBean testBean = (TestBean) beanFactory.getBean("testBean");
        System.out.println(testBean.getName());
    }
}
