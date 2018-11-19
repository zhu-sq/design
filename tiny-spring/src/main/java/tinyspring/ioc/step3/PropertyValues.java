package tinyspring.ioc.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropertyValues {

    private List<PropertyValue> propertyValues;

    public PropertyValues(){
        this.propertyValues = new ArrayList<>();
    }

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues(){
        return propertyValues;
    }
}
