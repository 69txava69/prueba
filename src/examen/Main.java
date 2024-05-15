package examen;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControlFederacion controlador = new ControlFederacion();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Dar de alta equipo");
            System.out.println("2. Dar de alta jugador");
            System.out.println("3. Mostrar jugadores por equipo");
            System.out.println("4. Marcar mejor jugador");
            System.out.println("5. Agregar kilómetros recorridos a jugador");
            System.out.println("6. Listar jugadores federados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Nombre del equipo: ");
                    String nombreEquipo = scanner.next();
                    System.out.print("División (1ª/2ª/3ª): ");
                    String division = scanner.next();
                    controlador.darDeAltaEquipo(nombreEquipo, division);
                    break;
                case 2:
                    System.out.print("Nombre del jugador: ");
                    String nombreJugador = scanner.next();
                    System.out.print("Apellido del jugador: ");
                    String apellidoJugador = scanner.next();
                    System.out.print("Número de dorsal: ");
                    int dorsal = scanner.nextInt();

                    System.out.println("Equipos disponibles:");
                    for (Equipo equipo : controlador.getEquipos()) {
                        System.out.println(equipo.getNombre());
                    }
                    System.out.print("Seleccione un equipo: ");
                    String nombreEquipoJugador = scanner.next();
                    Equipo equipoJugador = controlador.buscarEquipo(nombreEquipoJugador);
                    if (equipoJugador != null) {
                        controlador.darDeAltaJugador(nombreJugador, apellidoJugador, dorsal, equipoJugador);
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;
                case 3:
                    controlador.mostrarJugadoresPorEquipo();
                    break;
                
                case 4:
                    System.out.println("Equipos disponibles:");
                    for (Equipo equipo : controlador.getEquipos()) {
                        System.out.println(equipo.getNombre());
                    }
                    System.out.print("Seleccione un equipo: ");
                    String nombreEquipoMejorJugador = scanner.next();
                    Equipo equipoMejorJugador = controlador.buscarEquipo(nombreEquipoMejorJugador);

                    if (equipoMejorJugador != null) {
                        System.out.println("Jugadores del equipo " + equipoMejorJugador.getNombre() + ":");
                        List<Jugador> jugadoresEquipo = controlador.getJugadoresPorEquipo(equipoMejorJugador);
                        for (int i = 0; i < jugadoresEquipo.size(); i++) {
                            System.out.println((i + 1) + ". " + jugadoresEquipo.get(i).getNombre() + " " + jugadoresEquipo.get(i).getApellido());
                        }
                        System.out.print("Seleccione un jugador: ");
                        int opcionJugadorMejor = scanner.nextInt();
                        Jugador jugadorMejor = jugadoresEquipo.get(opcionJugadorMejor - 1);
                        controlador.marcarMejorJugador(equipoMejorJugador, jugadorMejor);
                        System.out.println(jugadorMejor.getNombre() + " " + jugadorMejor.getApellido() + " marcado como mejor jugador.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Equipos disponibles:");
                    for (Equipo equipo : controlador.getEquipos()) {
                        System.out.println(equipo.getNombre());
                    }
                    System.out.print("Seleccione un equipo: ");
                    String nombreEquipoKmRecorridos = scanner.next();
                    Equipo equipoKmRecorridos = controlador.buscarEquipo(nombreEquipoKmRecorridos);

                    if (equipoKmRecorridos != null) {
                        System.out.println("Jugadores del equipo " + equipoKmRecorridos.getNombre() + ":");
                        List<Jugador> jugadoresEquipo = controlador.getJugadoresPorEquipo(equipoKmRecorridos);
                        for (int i = 0; i < jugadoresEquipo.size(); i++) {
                            System.out.println((i + 1) + ". " + jugadoresEquipo.get(i).getNombre() + " " + jugadoresEquipo.get(i).getApellido());
                        }
                        System.out.print("Seleccione un jugador: ");
                        int opcionJugadorKm = scanner.nextInt();
                        Jugador jugadorKm = jugadoresEquipo.get(opcionJugadorKm - 1);

                        System.out.print("Ingrese los kilómetros recorridos por " + jugadorKm.getNombre() + " en el último partido: ");
                        int kmRecorridos = scanner.nextInt();
                        controlador.agregarKilometrosRecorridos(jugadorKm, kmRecorridos);
                        System.out.println("Kilómetros recorridos agregados correctamente.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;
         
                   
                case 6:
                    controlador.listarJugadoresFederados();
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}

