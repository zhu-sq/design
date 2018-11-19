package tinyspring.ioc.step2.factory;

import tinyspring.ioc.step2.BeanDefinition;

public interface BeanFactory {

    void registerBean(String name, BeanDefinition bean);

    Object getBean(String name);
}
