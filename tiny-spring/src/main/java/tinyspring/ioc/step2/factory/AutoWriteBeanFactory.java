package tinyspring.ioc.step2.factory;

import tinyspring.ioc.step2.BeanDefinition;

public class AutoWriteBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        }catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }

        return null;

    }
}
