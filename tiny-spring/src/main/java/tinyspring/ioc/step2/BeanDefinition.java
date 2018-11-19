package tinyspring.ioc.step2;

import lombok.Data;

@Data
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanName;

    public BeanDefinition(){}

    public void setBeanName(String name){
        this.beanName=name;

        try {
            this.beanClass = Class.forName(name);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
