package tinyspring.ioc.step6.beans;

import lombok.Data;

@Data
public class PropertyValue {

    private String name;

    private Object attr;

    public PropertyValue(String name, Object attr) {
        this.name = name;
        this.attr = attr;
    }

}
