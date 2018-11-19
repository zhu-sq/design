package tinyspring.ioc.step1;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private Map<String,BeanDefinition>  beanFactoryMap;

    public BeanFactory(){
        this.beanFactoryMap = new HashMap<>();
    }

    public Object getBean(String name){
        return beanFactoryMap.get(name).getBean();
    }


    public void addBean(String name,BeanDefinition beanDefinition){
        this.beanFactoryMap.put(name,beanDefinition);
    }
}
