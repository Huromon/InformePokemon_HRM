public class Pokemon {
    private int id;
    private String nombre;
    private Enum Tipos;
    private int nivel;
    private int ps;
    Pokemon(int id, String nombre, Enum Tipos, int nivel, int ps) {
        this.id = id;
        this.nombre = nombre;
        this.Tipos = Tipos;
        this.nivel = nivel;
        this.ps = ps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Enum getTipos() {
        return Tipos;
    }

    public void setTipos(Enum tipos) {
        Tipos = tipos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }
}
