public class Pokemon {
    private Integer id;
    private String nombre;
    private Enum tipos;
    private Integer nivel;
    private Integer ps;
    Pokemon(Integer id, String nombre, String Tipos, Integer nivel, Integer ps) {
        this.id = id;
        this.nombre = nombre;
        setTipos(Tipos);
        this.nivel = nivel;
        this.ps = ps;
    }

    public void setTipos(String tipo
    ) {

     switch(tipo.toUpperCase()) {
         case "ACERO" -> tipos=Tipos.ACERO;
         case "LUCHA" -> tipos=Tipos.LUCHA;
         case "ELECTRICO" -> tipos=Tipos.ELECTRICO;
         case "VOLADOR" -> tipos=Tipos.VOLADOR;
         case "BICHO" -> tipos=Tipos.BICHO;
         case "FANTASMA" -> tipos=Tipos.FANTASMA;
         case "NORMAL" -> tipos=Tipos.NORMAL;
         case "VENENO" -> tipos=Tipos.VENENO;
         case "SINIESTRO" -> tipos=Tipos.SINIESTRO;
         case "HIELO" -> tipos=Tipos.HIELO;
         case "TIERRA" -> tipos=Tipos.TIERRA;
         case "ROCA" -> tipos=Tipos.ROCA;
         case "PLANTA" -> tipos=Tipos.PLANTA;
         case "AGUA" -> tipos=Tipos.AGUA;
         case "FUEGO" -> tipos=Tipos.FUEGO;
         case "DRAGON" -> tipos=Tipos.DRAGON;
         case "HADA" -> tipos=Tipos.HADA;
         case "PSYQUICO" -> tipos=Tipos.PSIQUICO;

         default -> tipos=null;
     }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre.trim();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Enum getTipos() {
        return tipos;
    }

    public void setTipos(Enum tipos) {
        tipos = tipos;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {

        this.ps = ps;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", nombre=" + nombre + ", tipos=" + tipos + ", nivel=" + nivel + ", ps=" + ps + '}';
    }
}
