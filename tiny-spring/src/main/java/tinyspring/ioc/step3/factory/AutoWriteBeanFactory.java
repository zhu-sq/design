package tinyspring.ioc.step3.factory;

import tinyspring.ioc.step3.BeanDefinition;
import tinyspring.ioc.step3.PropertyValue;

import java.lang.reflect.Field;

public class AutoWriteBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCrateBean(BeanDefinition beanDefinition) {
        return createBeanInstance(beanDefinition);
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition){

        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            applyPropertyValues(bean,beanDefinition);
            return bean;
        }catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }

    public void applyPropertyValues(Object bean,BeanDefinition beanDefinition){

        if(beanDefinition.getPropertyValues() ==null) return;
        try{
            for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                field.set(bean,propertyValue.getAttr());
            }
        }catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }

    }
}
