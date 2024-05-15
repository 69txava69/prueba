package examen;

public class Equipo {
    private String nombre;
    private String division;

    public Equipo(String nombre, String division) {
        this.nombre = nombre;
        this.division = division;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDivision() {
        return division;
    }
}
