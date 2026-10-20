import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileService {



    private String fileName;
    private ConfigService configService;

    public FileService(ConfigService configService) {
        this.configService = configService;
        this.fileName = this.configService.getProperty("fichero");
    }

    public List<Pokemon> leerJson() {
        List<Pokemon> pokemons = new ArrayList<>();
        List<String> pokemonList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.equals("[") && !linea.equals("]")) {
                  pokemonList.add(linea);
                }
            }

        } catch (Exception e) {

        }
        for (String s : pokemonList) {
            List<String> parametro= new ArrayList<>();
           String[]  datos = s.split(",");
           for(String dato : datos) {
               String[] datos2 = dato.split(":");
               parametro.add(datos2[1]);
           }

               Integer id = Integer.parseInt(parametro.get(0));


           String name = parametro.get(1);
           String nombre="";
           String tipop = parametro.get(2);
           String tipo="";
           for(int q =1 ;q<name.length()-1;q++){
                nombre+=name.charAt(q);

            }
            for(int q =1 ;q<tipop.length()-1;q++){
                tipo+=tipop.charAt(q);

            }

           Integer nivel = Integer.parseInt(parametro.get(3));
           String rst ="";
           for(int i=0;i<parametro.get(4).length()-1;i++) {
               rst+=parametro.get(4).charAt(i);
           }
           Integer ps = Integer.parseInt(rst);

           Pokemon pokemon = new Pokemon(id,nombre,tipo,nivel,ps);
            System.out.println(pokemon);
            pokemons.add(pokemon);



        }
        return pokemons;

    }

    public String crearInforme(List<Pokemon> pokemons) {
        String Informe ="======================\n  INFORME DE POKEMON\n===========\n";
        Integer total = pokemons.size();
        Double nivelMedio = pokemons.stream().mapToDouble(Pokemon::getNivel).sum();
        nivelMedio = nivelMedio/total;
        Double psMedio = pokemons.stream().mapToDouble(Pokemon::getPs).sum();
        psMedio = psMedio/total;
        Informe += "\nTotal de pokemons = "+total;
        Informe += "\nNivel Medio = "+nivelMedio;
        List<String> nivel_max = new ArrayList<>();
        Integer maxsp=0;
         List<String> vida_max = new ArrayList<>();
        Integer maxnv=0;
        for (Pokemon pokemon : pokemons) {
          if(pokemon.getNivel()>maxnv){
              nivel_max.clear();
              nivel_max.add(pokemon.getNombre());
              maxnv = pokemon.getNivel();
          }else if(pokemon.getNivel()==maxnv){
              nivel_max.add(pokemon.getNombre());
          }
          if(pokemon.getPs()>maxsp){
              vida_max.clear();
              vida_max.add(pokemon.getNombre());
              maxsp = pokemon.getPs();
          }else if(pokemon.getPs()==maxsp){
              vida_max.add(pokemon.getNombre());
          }

        }
        Informe += "\nNivel Max = "+nivel_max;
        for(int i=0;i<.size();i++){}
        return Informe;
    }






}
