package techproed.utilities;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {



    public static String getProperty(String key){ //verilen key in valuesini return et diyoruz.

        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("configuration.properties");//java kodların dosyadan haberdar olması için file input oluşturduk
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);

    }

    @Test
    public void testName() {
        System.out.println(ConfigReader.getProperty("amazonUrl")); //https://amazon.com


    }
}


