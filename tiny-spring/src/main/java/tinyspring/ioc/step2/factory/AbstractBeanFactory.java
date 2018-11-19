package tinyspring.ioc.step2.factory;

import tinyspring.ioc.step2.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory {

    protected Map<String, BeanDefinition> beanDefinitionMap;

    AbstractBeanFactory(){
        this.beanDefinitionMap=new HashMap<>();
    }

    @Override
    public void registerBean(String name, BeanDefinition beanDefinition) {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        this.beanDefinitionMap.put(name,beanDefinition);
    }

    @Override
    public Object getBean(String name) {
        return this.beanDefinitionMap.get(name).getBean();
    }

    abstract Object doCreateBean(BeanDefinition beanDefinition);
}
