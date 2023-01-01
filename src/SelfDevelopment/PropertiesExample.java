package SelfDevelopment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String path = PropertiesExample.class.getResource("database.properties").getPath();
        path = URLDecoder.decode(path,"UTF-8");
        properties.load(new FileReader(path));

        String driver = properties.getProperty("driver");
        System.out.println("driver = " + driver);
        String url = properties.getProperty("url");
        System.out.println("url = " + url);
        String username = properties.getProperty("username");
        System.out.println("username = " + username);
        String password = properties.getProperty("password");
        System.out.println("password = " + password);


    }
}
