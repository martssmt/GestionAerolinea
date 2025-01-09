// Marta Lozano Marcos (bv0078)

import java.util.Scanner;

public class GestionAerolinea {

    // Propiedades: (Dado ya)

    private final int PRECIO_BILLETE_TURISTA = 350;     // Precio de un asiento de la clase turista

    private final int PRECIO_BILLETE_BUSINESS = 1500;   // Precio de un asiento de la clase business

    private final float DESCUENTO_INFANTIL = 15f;       // Se aplica un 15% de descuento a los menores de 15 años (<15)

    private final int NUM_AVIONES = 3;                  // Número de aviones de la aerolínea

    private Avion[] aviones;                            // Lista de aviones de la aerolínea
    private final int NUM_VUELOS = NUM_AVIONES;

    private Vuelo[] vuelos;                             // Lista de vuelos

    private boolean vuelosInicializados=false;          // Variable que indica si se han inicializado los datos de aviones y vuelos

    // Main (Dado ya)

    public static void main(String[] args) {
                // Creamos un objeto para ejecutar el programa
        GestionAerolinea obj = new GestionAerolinea();
    }

    // Constructor (Dado ya)

    public GestionAerolinea() {
                // Constructor de la clase que inicia el programa
        int opcion;
        do {
            opcion = menu();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

        // EjecutarOpcion (hecho)

    public void ejecutarOpcion(int opcion) {
                // Ejecuta el código asociado a la opción
        switch (opcion) {
            case 1: // Inicializar aviones y vuelos
                iniciarAvionesYVuelos();
                vuelosInicializados=true;
                System.out.println("Aviones y vuelos inicializados");
                System.out.println("\n");
                break;
            case 2: // Reservar asiento en un vuelo
                if (vuelosInicializados) {
                    Avion vuelo2 = preguntarVuelo().getAvion();
                    Clase clase = preguntarClase();
                    reservarAsiento(vuelo2, clase);
                }
                if (!vuelosInicializados) System.out.println("Error. Aviones y vuelos no inicializados");
                System.out.println("\n");
                break;
            case 3: // Mostrar el mapa de asientos
                if (vuelosInicializados) {
                    Avion vuelo3 = preguntarVuelo().getAvion();
                    vuelo3.mostrarMapaDeAsientos();
                }
                if (!vuelosInicializados) System.out.println("Error. Aviones y vuelos no inicializados");
                System.out.println("\n");
                break;
            case 4: // Mostrar la lista de pasajeros
                if (vuelosInicializados) {
                    Avion vuelo4 = preguntarVuelo().getAvion();
                    mostrarPasajeros(vuelo4);
                }
                if (!vuelosInicializados) System.out.println("Error. Aviones y vuelos no inicializados");
                System.out.println("\n");
                break;
            case 5: // Mostrar pasajeros menores de 15 años
                if (vuelosInicializados) {
                    Avion vuelo5 = preguntarVuelo().getAvion();
                    mostrarPasajeros(vuelo5, 15);
                }
                if (!vuelosInicializados) System.out.println("Error. Aviones y vuelos no inicializados");
                System.out.println("\n");
                break;
            case 6: // Mostrar ingresos del vuelo
                if (vuelosInicializados) {
                    Avion vuelo6 = preguntarVuelo().getAvion();
                    mostrarIngresos(vuelo6);
                }
                if (!vuelosInicializados) System.out.println("Error. Aviones y vuelos no inicializados");
                System.out.println("\n");
                break;
            default:
                System.out.println("Fin de la ejecución.");
                System.out.println("\n");
        }
    }

    // Iniciar Aviones y Vuelos (Dado ya)

    public void iniciarAvionesYVuelos() {
        // Se inicializan las listas de aviones y vuelos
        aviones = new Avion[NUM_AVIONES];
        aviones[0] = new Avion("Airbus A330", 40, 120);
        aviones[1] = new Avion("Airbus A310", 20, 100);
        aviones[2] = new Avion("Airbus A350", 48, 180);
        vuelos = new Vuelo[NUM_VUELOS];
        vuelos[0] = new Vuelo("Madrid", "La Habana", "01/12/2024", aviones[0]);
        vuelos[1] = new Vuelo("Madrid", "Cancún", "01/12/2024", aviones[1]);
        vuelos[2] = new Vuelo("Madrid", "Punta Cana", "01/12/2024", aviones[2]);
    }

        // Menu (hecho)

    public int menu() {
        System.out.println("\tMenú");
        System.out.println("1. Inicializar aviones y vuelos");
        System.out.println("2. Reservar asiento en un vuelo");
        System.out.println("3. Mostrar el mapa de asientos");
        System.out.println("4. Mostrar la lista de pasajeros");
        System.out.println("5. Mostrar pasajeros menores de 15 años");
        System.out.println("6. Mostrar ingresos del vuelo");
        System.out.println("0. Finalizar");
        int opcion;
        opcion=leerNumero(0, 6, "Introduzca un número entre 0 y 6: ");
        return opcion;
    }

    // Leer Numero (dado ya)

    public int leerNumero(int minimo, int maximo, String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            numero = teclado.nextInt();
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    // Preguntar Vuelo (dado ya)

    public Vuelo preguntarVuelo() {
        int numero;
        numero = leerNumero(0, 2, "Elija el vuelo (0: La Habana, 1: Cancún, 2: Punta Cana) ");
        return vuelos[numero];
    }

    // Preguntar clase (dado ya)

    public Clase preguntarClase() {
        Clase clase;
        int numero = leerNumero(0, 1, "Elija la clase (0: Business, 1: Turista) ");
        clase = numero == 0 ? Clase.BUSINESS : Clase.TURISTA;
        return clase;
    }

        // Reservar Asiento (hecho)

    public void reservarAsiento(Avion avion, Clase clase) {
        Pasajero pasajero = Azar.generaPasajero();
        Asiento asientoLibre = null;
        int fila = -1;
        int butaca = -1;
        int i = 1;
        int j = 1;
        boolean encontrado = false;
        if (clase == Clase.BUSINESS) {
            while (!encontrado && i <= avion.getNumeroFilas(Clase.BUSINESS)) {
                j = 1;
                while (!encontrado && j <= avion.getButacasPorFila()) {
                    if (avion.getAsientoBusiness(i-1, j-1) == null) {
                        encontrado = true;
                        fila = i;
                        butaca = j;
                    }
                    j++;
                }
                i++;
            }
        } else {       // if (clase==Clase.TURISTA)
            while (!encontrado && i <= avion.getNumeroFilas(Clase.TURISTA)) {
                j = 1;
                while (!encontrado && j <= avion.getButacasPorFila()) {
                    if (avion.getAsientoTurista(i-1, j-1) == null) {
                        encontrado = true;
                        fila = i;
                        butaca = j;
                    }
                    j++;
                }
                i++;
            }
        }
        if (encontrado) {
            asientoLibre = avion.reservarAsiento(fila, butaca, clase, pasajero);
        }
        if (asientoLibre!=null) {
            System.out.println("\nReservado el asiento " + asientoLibre + " de clase " + clase + " al pasajero " + pasajero.getNombre());
        } else {
            System.out.println("\nNo hay asientos libres en clase " + clase);
        }
    }


        // Mostrar Pasajeros (hecho)

    public void mostrarPasajeros(Avion avion) {
        System.out.println("\nAvión "+avion.getModelo());
        System.out.println("\nLista de pasajeros de la clase Business:");
        boolean filaAnteriorVacia=false;
        for (int i=0; i<avion.getNumeroFilas(Clase.BUSINESS); i++) {
            boolean filaVacia=true;
            String filaNum="\nFila " + (i+1) + ":";
            for (int j=0; j<avion.getButacasPorFila(); j++) {
                Asiento asiento=avion.getAsientoBusiness(i,j);
                if (asiento!=null) {
                    if (filaVacia) {
                        if (filaAnteriorVacia) {
                            System.out.println("...");
                        }
                        System.out.println(filaNum);
                        filaVacia=false;
                        filaAnteriorVacia=false;
                    }
                    System.out.printf(
                            "\t%-30s\t%-15s\t%9d años\n",
                            asiento.getPasajero().getNombre(),
                            asiento.getPasajero().getPasaporte(),
                            asiento.getPasajero().getEdad()
                    );
                } else if (!filaVacia) {
                System.out.println("\t(libre)");
                }
            }
            if (filaVacia) {
                if (!filaAnteriorVacia) {
                    System.out.println("\n...");
                }
                filaAnteriorVacia = true;
            } else {
                filaAnteriorVacia = false;
            }
        }
        System.out.println("\nLista de pasajeros de la clase Turista: ");
        filaAnteriorVacia = false;
        for (int i=0; i<avion.getNumeroFilas(Clase.TURISTA); i++) {
            boolean filaVacia=true;
            String filaNum="\nFila " + (i+1) + ":";
            for (int j=0; j<avion.getButacasPorFila(); j++) {
                Asiento asiento=avion.getAsientoTurista(i,j);
                if (asiento!=null) {
                    if (filaVacia) {
                        if (filaAnteriorVacia) {
                            System.out.println("...");
                        }
                        System.out.println(filaNum);
                        filaVacia=false;
                        filaAnteriorVacia=false;
                    }
                    System.out.printf(
                            "\t%-30s\t%-15s\t%9d años\n",
                            asiento.getPasajero().getNombre(),
                            asiento.getPasajero().getPasaporte(),
                            asiento.getPasajero().getEdad()
                    );
                } else if (!filaVacia) {
                    System.out.println("\t(libre)");
                }
            }
            if (filaVacia) {
                if (!filaAnteriorVacia) {
                    System.out.println("\n...");
                }
                filaAnteriorVacia = true;
            } else {
                filaAnteriorVacia = false;
            }
        }
    }

        // Mostrar Pasajeros Menores de Edad (hecho)

    public void mostrarPasajeros(Avion avion, int edad) {
        System.out.println("\nAvión "+avion.getModelo());
        System.out.println("Lista de pasajeros menores de "+edad+" años de la clase Business: ");
        for (int i=0; i<avion.getNumeroFilas(Clase.BUSINESS); i++) {
            for (int j=0; j<avion.getButacasPorFila(); j++) {
                Asiento asiento=avion.getAsientoBusiness(i,j);
                if (asiento!=null && asiento.getPasajero().getEdad()<edad) {
                    System.out.printf(
                            "\t%-30s\t\t\t%-9d años\n",
                            asiento.getPasajero().getNombre(),
                            asiento.getPasajero().getEdad()
                    );
                }
            }
        }
        System.out.println("\nLista de pasajeros menores de "+edad+" años de la clase Turista: ");
        for (int i=0; i<avion.getNumeroFilas(Clase.TURISTA); i++) {
            for (int j=0; j<avion.getButacasPorFila(); j++) {
                Asiento asiento=avion.getAsientoTurista(i,j);
                if (asiento!=null && asiento.getPasajero().getEdad()<edad) {
                    System.out.printf(
                            "\t%-30s\t\t\t%9d años\n",
                            asiento.getPasajero().getNombre(),
                            asiento.getPasajero().getEdad()
                    );
                }
            }
        }
    }

        // Mostrar Ingresos (hecho)

    public void mostrarIngresos(Avion avion) {
        double ingresos=0;
        int totalButacasBusiness=avion.getButacasPorFila()*avion.getNumeroFilas(Clase.BUSINESS);
        int totalButacasTurista=avion.getButacasPorFila()*avion.getNumeroFilas(Clase.TURISTA);
        int contBusA=0;
        int contTurA=0;
        int contBusI=0;
        int contTurI=0;
        for (int i=0; i<avion.getNumeroFilas(Clase.BUSINESS); i++) {
            for (int j=0; j<avion.getButacasPorFila(); j++) {
                if (avion.getAsientoBusiness(i,j)!=null&&avion.getAsientoBusiness(i,j).getPasajero().getEdad()>=15) {
                    contBusA++;
                }
                if (avion.getAsientoBusiness(i,j)!=null&&avion.getAsientoBusiness(i,j).getPasajero().getEdad()<15) {
                    contBusI++;
                }
            }
        }
        for (int i=0; i<avion.getNumeroFilas(Clase.TURISTA); i++) {
            for (int j=0; j<avion.getButacasPorFila(); j++) {
                if (avion.getAsientoTurista(i,j)!=null&&avion.getAsientoTurista(i,j).getPasajero().getEdad()>=15) {
                    contTurA++;
                }
                if (avion.getAsientoTurista(i,j)!=null&&avion.getAsientoTurista(i,j).getPasajero().getEdad()<15) {
                    contTurI++;
                }
            }
        }
        ingresos= (
                contBusA * PRECIO_BILLETE_BUSINESS +
                contBusI * (PRECIO_BILLETE_BUSINESS * (1 - DESCUENTO_INFANTIL / 100)) +
                contTurA * PRECIO_BILLETE_TURISTA +
                contTurI * (PRECIO_BILLETE_TURISTA * (1 - DESCUENTO_INFANTIL / 100))
        );
        System.out.printf("\nEl avión "+avion.getModelo()+" proporciona ingresos de %,.2f €", ingresos);
    }
}
