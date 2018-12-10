package tinyspring.ioc.step5.factory;

import tinyspring.ioc.step5.BeanDefinition;

public interface BeanFactory {

     Object getBean(String name);

     void registerBean(String name, BeanDefinition beanDefinition)  throws Exception;
}
