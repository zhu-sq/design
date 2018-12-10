package tinyspring.ioc.step6.context;

import tinyspring.ioc.step6.beans.BeanDefinition;
import tinyspring.ioc.step6.beans.factory.AutowireCapableBeanFactory;
import tinyspring.ioc.step6.beans.io.ResourceLoad;
import tinyspring.ioc.step6.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(configLocation,new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation,AutowireCapableBeanFactory beanFactory) throws Exception{
        super(beanFactory);
        this.configLocation =configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoad());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBean(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
