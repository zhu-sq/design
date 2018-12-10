package tinyspring.ioc.step4;

import lombok.Data;
import tinyspring.ioc.step4.PropertyValues;

@Data
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String className;

    private PropertyValues propertyValues;


    public BeanDefinition(){
        propertyValues = new PropertyValues();
    }
    public void setClassName(String className){
        try {
            this.className = className;
            this.beanClass = Class.forName(className);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
