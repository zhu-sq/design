package tinyspring.ioc.step5.factory;

import tinyspring.ioc.step5.BeanDefinition;
import tinyspring.ioc.step5.BeanReference;
import tinyspring.ioc.step5.PropertyValue;

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

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition)throws Exception{
        if(beanDefinition.getPropertyValues() ==null)
            return;
        for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                Object value = propertyValue.getAttr();
                if(value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getName());
                }

                if(field.getType() == Integer.class){
                    field.set(bean,Integer.valueOf((String)value));
                }else {
                    field.set(bean, value);
                }

        }
    }
}
