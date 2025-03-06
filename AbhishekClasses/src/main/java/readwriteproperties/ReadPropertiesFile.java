package readwriteproperties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {
    public static void main(String[] args) {
        File file = new File("src/main/resources/application.properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fis);
            System.out.println(fis.available());
            System.out.println(prop);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
