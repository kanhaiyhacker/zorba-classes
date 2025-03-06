package readwriteproperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class WritePropertiesFile {
    public static void main(String[] args) {
        File file = new File("src/main/resources/application.properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fis);
            prop.put("new", "true1");
            prop.put("new1", "true2");
            prop.put("new2", "true3");
            prop.put("new3", "true4");
            FileOutputStream fos = new FileOutputStream(file);
            prop.store(fos, "Updating the properties file");
            System.out.println(fis.available());
            System.out.println(prop);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
