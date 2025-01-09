public class Pasajero {

	// Propiedades

	private String nombre;
	private String pasaporte;
	private String telefono;
	private int edad;
	private Maleta maleta;

		// Constructor (hecho)

	public Pasajero(String nombre, String pasaporte, String telefono, int edad, Maleta maleta) {
		this.nombre = nombre;
		this.pasaporte = pasaporte;
		this.telefono = telefono;
		this.edad = edad;
		this.maleta = maleta;
	}

		// getNombre (hecho)

	public String getNombre() {
		return nombre;
	}

		// getPasaporte (hecho)

	public String getPasaporte() {
		return pasaporte;
	}

		// getTelefono (hecho)
	
	public String getTelefono() {
		return telefono;
	}

		// getEdad (hecho)

	public int getEdad() {
		return edad;
	}

		// getMaleta y que sea un objeto Maleta (hecho)

	public Maleta getMaleta() {
		return maleta;
	}
}
