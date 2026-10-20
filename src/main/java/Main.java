import java.io.File;

public class Main {

    public static void main(String[] args) {
        ConfigService configService = new ConfigService();
        FileService fileService = new FileService(configService);


        fileService.crearInforme(fileService.leerJson());



    }
}
