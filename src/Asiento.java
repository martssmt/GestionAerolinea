public class Asiento {

    // Propiedades

    private int fila;
    private int butaca;
    private Pasajero pasajero;

        // Constructor (hecho)

    public Asiento(int fila, int butaca, Pasajero pasajero) {
        this.fila = fila;
        this.butaca = butaca;
        this.pasajero = pasajero;
    }


        // getFila (hecho)

    public int getFila() {
        return fila;
    }

        // getButaca (hecho)

    public int getButaca() {
        return butaca;
    }

        // getPasajero desde Pasajero (hecho)

    public Pasajero getPasajero() {
        return pasajero;
    }

        // Transformador de Asiento de Butaca (hecho)

    @Override
    public String toString() {
        char letraButaca= (char) ('A' + (butaca-1));
        return fila + String.valueOf(letraButaca);
    }
}

