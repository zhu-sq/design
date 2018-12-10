package tinyspring.ioc.step5;

import tinyspring.ioc.step5.factory.AbstractBeanFactory;
import tinyspring.ioc.step5.factory.AutowireCapableBeanFactory;
import tinyspring.ioc.step5.io.ResourceLoad;
import tinyspring.ioc.step5.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{

        //1.读取配置文件，读取bean的配置信息
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoad());
        xmlBeanDefinitionReader.loadBeanDefinitions("step5/beans.xml");

        //2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBean(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }


        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

        //4.调用
        TestBean testBean = (TestBean) beanFactory.getBean("testBean");
        testBean.hello();
    }
}
