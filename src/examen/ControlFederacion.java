package examen;
 
import java.util.*;

public class ControlFederacion {
    private List<Equipo> equipos;
    private Map<Equipo, List<Jugador>> jugadoresPorEquipo;

    public ControlFederacion() {
        this.equipos = new ArrayList<>();
        this.jugadoresPorEquipo = new HashMap<>();
    }

    public void darDeAltaEquipo(String nombreEquipo, String division) {
        Equipo equipo = new Equipo(nombreEquipo, division);
        equipos.add(equipo);
        jugadoresPorEquipo.put(equipo, new ArrayList<>());
    }

    public void darDeAltaJugador(String nombre, String apellido, int dorsal, Equipo equipo) {
        Jugador jugador = new Jugador(nombre, apellido, dorsal);
        jugadoresPorEquipo.get(equipo).add(jugador);
    }

    public void mostrarJugadoresPorEquipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Equipos disponibles:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        System.out.print("Seleccione un equipo: ");
        int opcionEquipo = scanner.nextInt();
        Equipo equipoSeleccionado = equipos.get(opcionEquipo - 1);

        System.out.println("Jugadores del equipo " + equipoSeleccionado.getNombre() + ":");
        for (Jugador jugador : jugadoresPorEquipo.get(equipoSeleccionado)) {
            System.out.println(jugador.getNombre() + " " + jugador.getApellido() + " (" + jugador.getDorsal() + ")");
        }
    }

    public void marcarMejorJugador(Equipo equipo, Jugador jugador) {
        jugador.marcarComoMejorJugador();
    }

    public void agregarKilometrosRecorridos(Jugador jugador, int kmRecorridos) {
        jugador.agregarKilometrosRecorridos(kmRecorridos);
    }

    public void listarJugadoresFederados() {
        System.out.println("Listado de jugadores federados:");
        for (Equipo equipo : equipos) {
            for (Jugador jugador : jugadoresPorEquipo.get(equipo)) {
                System.out.println(equipo.getNombre() + " | " + jugador.getInfoJugador());
            }
        }
    }

    public Equipo buscarEquipo(String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                return equipo;
            }
        }
        return null; // Equipo no encontrado
    }

    public Equipo[] getEquipos() {
        return equipos.toArray(new Equipo[0]);
    }

    public List<Jugador> getJugadoresPorEquipo(Equipo equipo) {
        return jugadoresPorEquipo.getOrDefault(equipo, new ArrayList<>());
    }
}
