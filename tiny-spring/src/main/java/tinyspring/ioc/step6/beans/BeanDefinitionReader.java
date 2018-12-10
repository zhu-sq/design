package tinyspring.ioc.step6.beans;

public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
