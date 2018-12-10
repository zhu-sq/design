package tinyspring.ioc.step6.beans.io;


import java.net.URL;

public class ResourceLoad {
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
