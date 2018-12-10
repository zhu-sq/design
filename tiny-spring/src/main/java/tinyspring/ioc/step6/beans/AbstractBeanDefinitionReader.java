package tinyspring.ioc.step6.beans;

import lombok.Data;
import tinyspring.ioc.step6.beans.io.ResourceLoad;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;
    private ResourceLoad resourceLoad;

    protected AbstractBeanDefinitionReader(ResourceLoad resourceLoad){
        this.resourceLoad =resourceLoad;
        this.registry = new HashMap<>();
    }

}
