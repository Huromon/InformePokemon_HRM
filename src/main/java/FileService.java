import javax.sound.midi.MidiDevice;
import java.io.*;
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
            pokemons.add(pokemon);



        }
        return pokemons;

    }

    public void crearInforme(List<Pokemon> pokemons) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("informe.txt"))) {

            bw.write("======================");
            bw.newLine();

            bw.write(" INFORME DE POKEMON"); ;
            bw.newLine();
            bw.write("======================");
            bw.newLine();

            Integer total = pokemons.size();
            Double nivelMedio = pokemons.stream().mapToDouble(Pokemon::getNivel).sum();
            nivelMedio = nivelMedio / total;
            Double psMedio = pokemons.stream().mapToDouble(Pokemon::getPs).sum();
            psMedio = psMedio / total;
            bw.write("Total de pokemons = " + total);
            bw.newLine();
            bw.write("Nivel Medio = " + nivelMedio);
            bw.newLine();
            bw.write( "Ps Medio = " + psMedio);
            bw.newLine();
            List<String> nivel_max = new ArrayList<>();
            Integer maxsp = 0;
            List<String> vida_max = new ArrayList<>();
            Integer maxnv = 0;
            for (Pokemon pokemon : pokemons) {
                if (pokemon.getNivel() > maxnv) {
                    nivel_max.clear();
                    nivel_max.add(pokemon.getNombre());
                    maxnv = pokemon.getNivel();

                } else if (pokemon.getNivel() == maxnv) {
                    nivel_max.add(pokemon.getNombre());
                }
                if (pokemon.getPs() > maxsp) {
                    vida_max.clear();
                    vida_max.add(pokemon.getNombre());
                    maxsp = pokemon.getPs();
                } else if (pokemon.getPs() == maxsp) {
                    vida_max.add(pokemon.getNombre());
                }

            }
            bw.write( "Nivel Max (" + maxnv + "):");
            bw.newLine();
            for (int i = 0; i < nivel_max.size(); i++) {

                bw.write(nivel_max.get(i));
                bw.newLine();
            }

            bw.write("PS Max (" + maxsp + "):");
            bw.newLine();
            for (int i = 0; i < vida_max.size(); i++) {

                bw.write(vida_max.get(i));
                bw.newLine();
            }

            bw.write("---------------" );
            bw.newLine();
            bw.write(" Pokemons por tipo "); ;
            bw.newLine();
            bw.write("---------------" );
            bw.newLine();


            for (Tipos tipo : Tipos.values()) {
                Boolean existe = false;
                for (Pokemon pokemon : pokemons) {
                    if (tipo.equals(pokemon.getTipos())) {
                        if (!existe) {
                            bw.write("Tipo: " + tipo.toString());
                            bw.newLine();
                        }
                        existe = true;

                        bw.write(pokemon.getNombre());
                        bw.newLine();
                    }
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    }







