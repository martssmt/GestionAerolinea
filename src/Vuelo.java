public class Vuelo {

    // Propiedades:

    private String paisOrigen;
    private String paisDestino;
    private String fecha;
    private Avion avion;

        // Vuelo (hecho)

    public Vuelo(String paisOrigen, String paisDestino, String fecha, Avion avion) {
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.fecha = fecha;
        this.avion = avion;
    }

        // getPaisOrigen (hecho)

    public String getPaisOrigen() {
        return paisOrigen;
    }

        // getPaisDestino (hecho)

    public String getPaisDestino() {
        return paisDestino;
    }

        // getFecha (hecho)

    public String getFecha() {
        return fecha;
    }

        // getAvion (hecho)

    public Avion getAvion() {
        return avion;
    }
}
