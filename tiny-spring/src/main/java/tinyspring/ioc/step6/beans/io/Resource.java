package tinyspring.ioc.step6.beans.io;

import java.io.InputStream;

public interface Resource {
    InputStream getInputStream() throws Exception;
}
