package tinyspring.ioc.step6.beans.factory;

import tinyspring.ioc.step6.beans.BeanDefinition;

public interface BeanFactory {

     Object getBean(String name) throws Exception;

}
