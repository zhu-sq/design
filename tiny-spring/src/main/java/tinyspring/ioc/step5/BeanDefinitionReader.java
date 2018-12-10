package tinyspring.ioc.step5;

public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
