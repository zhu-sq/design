package tinyspring.ioc.step5.io;

import java.io.InputStream;

public interface Resource {
    InputStream getInputStream() throws Exception;
}
