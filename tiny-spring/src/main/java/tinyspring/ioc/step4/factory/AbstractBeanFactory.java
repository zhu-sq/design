package tinyspring.ioc.step4.factory;

import tinyspring.ioc.step4.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap;

    public AbstractBeanFactory(){
        this.beanDefinitionMap = new HashMap<>();
    }

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }


    @Override
    public void registerBean(String name, BeanDefinition beanDefinition)  throws Exception{
       Object bean = doCrateBean(beanDefinition);
       beanDefinition.setBean(bean);
       beanDefinitionMap.put(name,beanDefinition);

    }

    protected abstract Object doCrateBean(BeanDefinition beanDefinition)  throws Exception;

}
