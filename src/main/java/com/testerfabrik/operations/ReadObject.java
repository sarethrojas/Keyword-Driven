package com.testerfabrik.operations;

import java.io.*;
import java.util.Properties;

public class ReadObject {
    Properties p = new Properties();

    public Properties getObjectRepositoy() throws IOException {
        File file = new File(System.getProperty("user.dir")+"/resources/object.properties");
        InputStream stream = new FileInputStream(file);
        p.load(stream);
        return p;
    }
}
