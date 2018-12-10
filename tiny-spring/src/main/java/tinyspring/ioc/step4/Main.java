package tinyspring.ioc.step4;

import tinyspring.ioc.step4.factory.AutowireCapableBeanFactory;
import tinyspring.ioc.step4.factory.BeanFactory;
import tinyspring.ioc.step4.io.ResourceLoad;
import tinyspring.ioc.step4.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{

        //1.读取配置文件，读取bean的配置信息
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoad());
        xmlBeanDefinitionReader.loadBeanDefinitions("step4/beans.xml");

        //2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBean(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        //3.获取bean
        TestBean testBean = (TestBean) beanFactory.getBean("testBean");
        System.out.println(testBean);
    }
}
