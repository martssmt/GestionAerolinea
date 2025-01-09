public class Maleta {

    // Propiedades:

    private final double PESO_MAXIMO = 23;
    private double peso;
    private final int MEDIDA_TOTAL_MAXIMA = 190;
    private int ancho;
    private int alto;
    private int fondo;

        // Constructor (hecho)

    public Maleta(double peso, int ancho, int alto, int fondo) {
        this.peso = peso;
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
    }

        // Getters (hecho)

    public double getPeso() {
        return peso;
    }

    public int getMedidaTotal() {
        return ancho + alto + fondo;
    }

        // excedeDePeso (hecho)

    public boolean excedeDePeso() {
        return this.peso > PESO_MAXIMO;
    }

        // excedeDeMedidas (hecho)

    public boolean excedeDeMedidas() {
        return this.getMedidaTotal() > MEDIDA_TOTAL_MAXIMA;
    }

}
