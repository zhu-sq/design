package tinyspring.ioc.step3.factory;

import tinyspring.ioc.step3.BeanDefinition;

public interface BeanFactory {

     Object getBean(String name);

     void registerBean(String name, BeanDefinition beanDefinition);
}
