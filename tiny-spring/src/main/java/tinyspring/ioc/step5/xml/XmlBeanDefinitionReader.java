package tinyspring.ioc.step5.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tinyspring.ioc.step5.AbstractBeanDefinitionReader;
import tinyspring.ioc.step5.BeanDefinition;
import tinyspring.ioc.step5.BeanReference;
import tinyspring.ioc.step5.PropertyValue;
import tinyspring.ioc.step5.io.ResourceLoad;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoad resourceLoad){
        super(resourceLoad);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception{
        InputStream inputStream = getResourceLoad().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        registerBeanDefinitions(document);
        inputStream.close();
    }

    private void registerBeanDefinitions(Document document){
        Element root = document.getDocumentElement();

        paresBeanDefinitions(root);
    }

    private void paresBeanDefinitions(Element root ){
        NodeList nodeList =  root.getChildNodes();
        for(int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if(node.getNodeType()  == Node.ELEMENT_NODE){
                Element element = (Element) node;
                processBeanDefinition(element);
            }

        }
    }

    private void processBeanDefinition(Element element){
        String name = element.getAttribute("name");
        String className  =element.getAttribute("class");
        BeanDefinition beanDefinition  = new BeanDefinition();
        processPorperty(element,beanDefinition);
        beanDefinition.setClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    private void processPorperty(Element ele, BeanDefinition beanDefinition){
        NodeList nodeList = ele.getElementsByTagName("property");
        for(int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element propertyEle = (Element) node;
                String name  =  propertyEle.getAttribute("name");
                Object value = propertyEle.getAttribute("value");

                if(value!=null && ((String) value).length()>0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }else{
                    String ref = propertyEle.getAttribute("ref");
                    if(ref==null || ref.length() ==0){
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }

                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }

}
