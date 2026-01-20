package ch.heroin.xmlparser;

import java.io.InputStream;

public class ResourceLoader {

    public static InputStream open(String resourceName) {
        InputStream in = ResourceLoader.class.getClassLoader().getResourceAsStream(resourceName);
        if (in == null) {
            throw new IllegalArgumentException("Resource not found on classpath: " + resourceName);
        }
        return in;
    }
}