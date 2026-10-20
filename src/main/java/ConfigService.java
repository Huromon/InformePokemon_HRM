import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigService {

    public final Properties props = new Properties();

    public ConfigService(){
        try {
            props.load(new FileReader("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de configuración", e);
        }
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }
}
