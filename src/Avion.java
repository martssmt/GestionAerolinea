
// YA IMPLEMENTADA! NO TOCAR NADA!


// Tipo enumerado para indicar la clase o categoría a la que pertenece el asiento del avión

enum Clase {BUSINESS, TURISTA};

public class Avion {
				// Clase que guarda la información del avión y de los asientos asignados
				// Los arrays empiezan en 0, por tanto, la fila: 1, asiento: 1 de la clase business
				// se corresponderá con asientoBusiness[0][0], siempre [fila-1][asiento-1]

	// Propiedades:

	private final int ASIENTOS_X_FILA = 4;
	private String modelo;
	private int numeroAsientosBusiness;
	private Asiento[][] asientoBusiness;
	private int numeroAsientosTurista;
	private Asiento[][] asientoTurista;

	// Constructor

	public Avion(String modelo, int business, int turista) {
		this.modelo = modelo;
		numeroAsientosBusiness = business;
		numeroAsientosTurista = turista;
		asientoBusiness = new Asiento[business/ASIENTOS_X_FILA][ASIENTOS_X_FILA];
		asientoTurista = new Asiento[turista/ASIENTOS_X_FILA][ASIENTOS_X_FILA];
	}

	// getModelo

	public String getModelo() {
		return modelo;
	}

	// getNumeroFilas

	public int getNumeroFilas(Clase clase) {
		if (clase == Clase.BUSINESS)
			return numeroAsientosBusiness/ASIENTOS_X_FILA;
		else
			return numeroAsientosTurista/ASIENTOS_X_FILA;
	}

	// getButacasPorFila

	public int getButacasPorFila() {
		return ASIENTOS_X_FILA;
	}

	// getPasajero

	public Pasajero getPasajero(int fila, int butaca, Clase clase) {
		Pasajero pasajero = null;
		Asiento asiento = clase == Clase.BUSINESS ? asientoBusiness[fila-1][butaca-1] :
													asientoTurista[fila-1][butaca-1];
		if (asiento != null)
			pasajero = asiento.getPasajero();
		return pasajero;
	}

	// reservarAsiento

	public Asiento reservarAsiento(int fila, int butaca, Clase clase, Pasajero pasajero) {
		Asiento asientoAsignado = null;
		if (clase == Clase.BUSINESS) {
			if (asientoBusiness[fila-1][butaca-1] == null) {
				asientoAsignado = new Asiento(fila, butaca, pasajero);
				asientoBusiness[fila-1][butaca-1] = asientoAsignado;
			}
		}
		else // Clase.TURISTA
			if (asientoTurista[fila-1][butaca-1] == null) {
				asientoAsignado = new Asiento(fila, butaca, pasajero);
				asientoTurista[fila-1][butaca-1] = asientoAsignado;
			}
		return asientoAsignado;
	}

	// mostrarMapaDeAsientos

	public void mostrarMapaDeAsientos() {
		System.out.println("\nAvión " + modelo);
		for (int butaca = 0; butaca < ASIENTOS_X_FILA; butaca++) {
			for (int fila = 0; fila < asientoBusiness.length; fila++)
				System.out.print(asientoBusiness[fila][butaca] != null ? "B" : "·");
			System.out.print(" ");
			for (int fila = 0; fila < asientoTurista.length; fila++)
				System.out.print(asientoTurista[fila][butaca]!= null ? "T" : "·");
			System.out.println();
		}
	}

		// getAsientoTurista (añadidos)

	public Asiento getAsientoTurista(int fila, int butaca) {
		return asientoTurista[fila][butaca];
	}

		// getAsientoBusiness (añadidos)

	public Asiento getAsientoBusiness(int fila, int butaca) {
		return asientoBusiness[fila][butaca];
	}
}
