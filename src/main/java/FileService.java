public class FileService {


    private String fileName;
    private ConfigService configService;

    public FileService(ConfigService configService) {
        this.configService = configService;
        this.fileName = this.configService.getProperty("fichero");
    }



}
