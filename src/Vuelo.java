public class Vuelo {

    // Propiedades:

    private String paisOrigen;
    private String paisDestino;
    private String fecha;
    private Avion avion;

        // Constructor (hecho)

    public Vuelo(String paisOrigen, String paisDestino, String fecha, Avion avion) {
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.fecha = fecha;
        this.avion = avion;
    }

        // Getters (hecho)

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public String getFecha() {
        return fecha;
    }

    public Avion getAvion() {
        return avion;
    }
}
