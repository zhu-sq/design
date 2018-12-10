package tinyspring.ioc.step4.io;

import java.io.InputStream;

public interface Resource {
    InputStream getInputStream() throws Exception;
}
