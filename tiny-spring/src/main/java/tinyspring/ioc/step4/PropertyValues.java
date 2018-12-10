package tinyspring.ioc.step4;

import java.util.ArrayList;
import java.util.List;

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
