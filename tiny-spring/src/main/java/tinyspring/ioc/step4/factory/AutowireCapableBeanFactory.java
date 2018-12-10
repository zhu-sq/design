package tinyspring.ioc.step4.factory;

import tinyspring.ioc.step4.BeanDefinition;
import tinyspring.ioc.step4.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCrateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition)throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    private void applyPropertyValues(Object bean,BeanDefinition beanDefinition)throws Exception{
        if(beanDefinition.getPropertyValues() ==null)
            return;
        for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                if(field.getType() == Integer.class){
                    field.set(bean,Integer.valueOf((String)propertyValue.getAttr()));
                }else {
                    field.set(bean, propertyValue.getAttr());
                }
        }
    }
}
