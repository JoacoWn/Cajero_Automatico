package org.example;

import java.util.Scanner;

public class Cajero {

    private static int saldo = 100000;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Ejecuta el menú principal del programa y gestiona la interacción con el usuario.
     */
    public static void main(String[] args) {
        menu(); // Inicia el menú
    }

    public static void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            if (opcion != -1) {
                ejecutarOpcion(opcion);
            }
        } while (opcion != 4); // Cambié la opción de salida a 4 (salir)
    }

    /**
     * Muestra el menú principal con las opciones disponibles.
     */
    private static void mostrarOpciones() {
        System.out.println("======================================");
        System.out.println("===Bienvenido al Cajero Automático===");
        System.out.println("======================================");
        System.out.println("Ingrese una opción: ");
        System.out.println("1. Retirar Fondos");
        System.out.println("2. Consultar Fondos");
        System.out.println("3. Depositar Fondos");
        System.out.println("4. Reiniciar Fondos");
        System.out.println("5. Salir");
    }

    /**
     * Obtiene la opción ingresada por el usuario.
     * @return Opción seleccionada por el usuario o -1 si la entrada no es válida.
     */
    public static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido");
            return -1;
        }
    }

    /**
     * Ejecuta la acción correspondiente según la opción seleccionada.
     * @param opcion Opción ingresada por el usuario.
     */
    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> retirar();
            case 2 -> consultarSaldo();
            case 3 -> depositar();
            case 4 -> reiniciarSaldo();
            case 5 -> salir();
            default -> System.out.println("Opción inválida...");
        }
    }

    /**
     * Realiza un retiro de dinero si las condiciones son válidas.
     */
    public static void retirar() {
        System.out.print("Ingrese el monto a retirar: ");
        try {
            // Primero leemos el monto
            int monto = Integer.parseInt(scanner.nextLine());

            // Validamos que el monto sea positivo y no exceda el saldo
            if (monto <= saldo && monto > 0) {
                saldo -= monto;  // Restamos el monto del saldo
                System.out.println("Monto a retirar: " + monto);
                System.out.println("Retiro realizado correctamente.");
            } else {
                System.out.println("Su retiro excede su saldo o el monto ingresado no es válido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
        }
    }


    /**
     * Deposita un monto de dinero al saldo, si es válido.
     */
    public static void depositar() {
        System.out.print("Ingrese el monto a depositar: ");
        try {
            // Primero leemos el monto
            int monto = Integer.parseInt(scanner.nextLine());

            // Validamos que el monto sea positivo y no exceda el saldo
            if (monto > 0) {
                saldo += monto;  // Restamos el monto del saldo
                System.out.println("Monto a depositar: " + monto);
                System.out.println("Deposito realizado correctamente.");
            } else {
                System.out.println("El monto ingresado no es válido , ingrese con un valor mayor a 0.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
        }
    }

    /**
     * Retorna el saldo disponible en la cuenta simulada.
     */
    public static void consultarSaldo() {
        System.out.println("Su saldo disponible es: " + saldo);
    }

    /**
     * Reinicia el saldo a un valor inicial fijo (usado en pruebas).
     */
    public static void reiniciarSaldo() {
        saldo = 100000;
    }

    public static void salir() {
        System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
        // No se puede usar break aquí, no estás dentro de un switch o bucle.
    }
}
