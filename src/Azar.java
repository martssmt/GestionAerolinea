
// YA IMPLEMENTADA! NO TOCAR NADA!


public class Azar {

    // Genera Nombres

    private static String generaNombre() {
        // Genera un String con un nombre y dos apellidos

        String resul;
        String[] nombres = {"Miguel", "Maria", "Susana", "Octavio", "Soledad",
        		"Juan", "Javier", "Pilar", "Adolfo", "Victor", "Jose", "Rocio", 
        		"Claudia", "Ana", "Sonia", "Francisco", "Esmeralda", "Jorge",
                "Celia", "Tomas", "Ramon", "Violeta"};
        String[] apellidos = {"Diaz", "Fernandez", "Lopez", "Delgado",
        		"Hernandez", "Perez", "Garcia", "Martinez", "Suarez",
                "Rodriguez", "Gutierrez", "Sevilla", "Gomez", "Arroyo", 
                "Toledo", "Segovia", "Madrid", "Cuenca", "Lugo", "Cano", 
                "Castillo", "Alameda"};
        resul = nombres[(int)(Math.random()*nombres.length)] + " " +
                apellidos[(int)(Math.random()*apellidos.length)] + " " +
                apellidos[(int)(Math.random()*apellidos.length)];
        return resul;
    }

    // Genera numeros de longitud concreta

    private static String generaNum(int longitud) {
        // Genera un String numérico con la longitud indicada
        String caracteres = "1234567890";
        String resul = "";
        char car;
        for (int i = 0; i < longitud; i++) {
            car = caracteres.charAt((int)(Math.random()*caracteres.length()));
            resul += car;
        }
        return resul;
    }

    // Genera pasaportes
    
    private static String generaPasaporte() {
    	// El pasaporte tiene el formato de 3 letras seguidas de 6 números,
    	// p.e. ABC123456
    	String resul = "";
    	for (int i = 0; i < 3; i++)
    		resul += (char)(Math.random()*26+'A');
    	resul += generaNum(6);
    	return resul;
    }

    // Genrera Telefonos

    private static String generaTelefono() {
    	// Genera un número de telefono de 9 cifras que empieza siempre por 6
        String resul;
        resul = "6" + generaNum(8);
    	return resul;
    }

    // Genera edades

    private static int generaEdad() {
    	// Genera un número entre 1 y 99
        int resul;
        resul = (int)(Math.random()*99)+1;
    	return resul;
    }

    // Genera Maletas y sus datos

    private static Maleta generaMaleta() {
        // Genera los datos de una maleta aleatoriamente
        Maleta resul;
        double peso = Math.random()*30+2;       // [2,32)
        int ancho = (int)(Math.random()*30)+30; // [30, 60)
        int alto  = (int)(Math.random()*30)+50; // [50, 80)
        int fondo = (int)(Math.random()*20)+20; // [20, 40)
        resul = new Maleta(peso, ancho, alto, fondo);
        return resul;
    }

    // Genera pasajeros y sus datos

    public static Pasajero generaPasajero() {
        //Genera un nuevo pasajero con datos aleatorios
    	return new Pasajero(generaNombre(), generaPasaporte(), generaTelefono(), 
    						generaEdad(), generaMaleta());
    }
}
