package tinyspring.ioc.step4;

public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
