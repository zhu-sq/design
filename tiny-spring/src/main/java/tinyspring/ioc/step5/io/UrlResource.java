package tinyspring.ioc.step5.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url){
        this.url=url;
    }

    @Override
    public InputStream getInputStream() throws Exception{
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
