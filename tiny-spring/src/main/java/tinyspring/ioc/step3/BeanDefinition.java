package tinyspring.ioc.step3;

import lombok.Data;

@Data
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String className;

    private PropertyValues propertyValues;


    public void setClassName(String className){
        try {
            this.className = className;
            this.beanClass = Class.forName(className);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
