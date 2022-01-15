package com.kingyal.factorytest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyFactory {
    private Properties properties = new Properties();

    public MyFactory() {
    }

    public MyFactory(String configFile) throws IOException {
        InputStream inputStream = MyFactory.class.getResourceAsStream(configFile);
        properties.load(inputStream);
    }

    public Object getBean(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String classPath = properties.getProperty(name);
        Class cls = Class.forName(classPath);
        return cls.newInstance();

    }
}
