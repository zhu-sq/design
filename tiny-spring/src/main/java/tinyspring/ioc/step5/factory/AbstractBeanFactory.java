package tinyspring.ioc.step5.factory;

import tinyspring.ioc.step5.BeanDefinition;

import java.util.*;

public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap;

    public AbstractBeanFactory(){
        this.beanDefinitionMap = new HashMap<>();
    }


    private final List<String> beanDefinitionNames = new ArrayList<String>();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }


    @Override
    public void registerBean(String name, BeanDefinition beanDefinition)  throws Exception{
       Object bean = doCrateBean(beanDefinition);
       beanDefinition.setBean(bean);
       beanDefinitionMap.put(name,beanDefinition);
       beanDefinitionNames.add(name);
    }


    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    protected abstract Object doCrateBean(BeanDefinition beanDefinition)  throws Exception;

}
