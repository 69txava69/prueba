package examen;

public class Jugador {
    private String nombre;
    private String apellido;
    private int dorsal;
    private int vecesMejorJugador;
    private int totalKmRecorridos;
    private int partidosJugados;

    public Jugador(String nombre, String apellido, int dorsal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dorsal = dorsal;
        this.vecesMejorJugador = 0;
        this.totalKmRecorridos = 0;
        this.partidosJugados = 0;
    }

    /**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido el apellido a establecer
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return el dorsal
	 */
	public int getDorsal() {
		return dorsal;
	}

	/**
	 * @param dorsal el dorsal a establecer
	 */
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	/**
	 * @return el vecesMejorJugador
	 */
	public int getVecesMejorJugador() {
		return vecesMejorJugador;
	}

	/**
	 * @param vecesMejorJugador el vecesMejorJugador a establecer
	 */
	public void setVecesMejorJugador(int vecesMejorJugador) {
		this.vecesMejorJugador = vecesMejorJugador;
	}

	/**
	 * @return el totalKmRecorridos
	 */
	public int getTotalKmRecorridos() {
		return totalKmRecorridos;
	}

	/**
	 * @param totalKmRecorridos el totalKmRecorridos a establecer
	 */
	public void setTotalKmRecorridos(int totalKmRecorridos) {
		this.totalKmRecorridos = totalKmRecorridos;
	}

	/**
	 * @return el partidosJugados
	 */
	public int getPartidosJugados() {
		return partidosJugados;
	}

	/**
	 * @param partidosJugados el partidosJugados a establecer
	 */
	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public void agregarKilometrosRecorridos(int kmRecorridos) {
        this.totalKmRecorridos += kmRecorridos;
        this.partidosJugados++;
    }

    public void marcarComoMejorJugador() {
        this.vecesMejorJugador++;
    }

    public String getInfoJugador() {
        double mediaKmPorPartido = (double) this.totalKmRecorridos / this.partidosJugados;
        return String.format("%s %s | %.2f km/partido | %d veces", nombre, apellido, mediaKmPorPartido, vecesMejorJugador);
    }
}



