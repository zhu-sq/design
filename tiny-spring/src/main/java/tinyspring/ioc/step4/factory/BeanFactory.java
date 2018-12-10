package tinyspring.ioc.step4.factory;

import tinyspring.ioc.step4.BeanDefinition;

public interface BeanFactory {

     Object getBean(String name);

     void registerBean(String name, BeanDefinition beanDefinition)  throws Exception;
}
