package tinyspring.ioc.step3;

import tinyspring.ioc.step3.factory.AutoWriteBeanFactory;
import tinyspring.ioc.step3.factory.BeanFactory;

public class Main {

    public static void main(String[] args){

        //初始化bean工厂
        BeanFactory beanFactory = new AutoWriteBeanFactory();


        //设置bean的属性
        PropertyValue propertyValue1 = new PropertyValue("name","这是猪的名字");
        PropertyValue propertyValue2 = new PropertyValue("sex","女");
        PropertyValue propertyValue3 = new PropertyValue("id",123456);

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(propertyValue1);
        propertyValues.addPropertyValue(propertyValue2);
        propertyValues.addPropertyValue(propertyValue3);

        //初始化beanDefinition
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setPropertyValues(propertyValues);
        beanDefinition.setClassName("tinyspring.ioc.step3.TestBean");

        //注入工厂
        beanFactory.registerBean("testBean",beanDefinition);


        //从工厂中获取值
        TestBean testBean  = (TestBean) beanFactory.getBean("testBean");
        System.out.println(testBean.toString());
    }
}
