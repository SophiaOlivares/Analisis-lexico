import java.util.Scanner;

public class AnalizadorLexico {

    // Método para verificar si un carácter es una letra
    public static boolean esLetra(char c) {
        return Character.isLetter(c);
    }

    // Método para verificar si un carácter es un dígito
    public static boolean esDigito(char c) {
        return Character.isDigit(c);
    }

    // Método para verificar si un carácter es un espacio en blanco
    public static boolean esEspacioEnBlanco(char c) {
        return Character.isWhitespace(c);
    }

    // Método para analizar si el token es un identificador (solo letras)
    public static boolean esIdentificador(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (!esLetra(token.charAt(i))) {
                return false; // Si encuentra un carácter que no es letra, no es un identificador válido
            }
        }
        return true; // Todos los caracteres son letras
    }

    // Método para verificar si el token es un número entero
    public static boolean esEntero(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (!esDigito(token.charAt(i))) {
                return false; // Si encuentra un carácter que no es un dígito, no es un entero
            }
        }
        return true; // Todos los caracteres son dígitos
    }

    // Método para verificar si el token es un número decimal
    public static boolean esDecimal(String token) {
        boolean puntoEncontrado = false;
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (c == '.') {
                if (puntoEncontrado) {
                    return false; // Si ya se encontró un punto antes, no puede ser un decimal
                }
                puntoEncontrado = true; // Marca que se encontró el punto decimal
            } else if (!esDigito(c)) {
                return false; // Si no es un dígito ni un punto, no es un decimal
            }
        }
        return puntoEncontrado; // Solo es decimal si contiene un punto
    }

    // Método para verificar si el token es un operador de asignación
    public static boolean esOperadorAsignacion(String token) {
        return token.equals("=");
    }

    // Método para verificar si el token es un operador de suma
    public static boolean esOperadorSuma(String token) {
        return token.equals("+") || token.equals("+=");
    }

    public static void analizarCadena(String cadena) {
        String[] tokens = cadena.split("\\s+"); // Divide la cadena en tokens separados por espacios en blanco

        for (String token : tokens) {
            if (esIdentificador(token)) {
                System.out.println("El token \"" + token + "\" es un identificador válido.");
            } else if (esEntero(token)) {
                System.out.println("El token \"" + token + "\" es un número entero válido.");
            } else if (esDecimal(token)) {
                System.out.println("El token \"" + token + "\" es un número decimal válido.");
            } else if (esOperadorAsignacion(token)) {
                System.out.println("El token \"" + token + "\" es un operador de asignación.");
            } else if (esOperadorSuma(token)) {
                System.out.println("El token \"" + token + "\" es un operador de suma.");
            } else {
                System.out.println("El token \"" + token + "\" no es válido.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una cadena para analizar:");
        String cadena = scanner.nextLine();

        analizarCadena(cadena); // Analiza los tokens dentro de la cadena

        scanner.close();
    }
}
