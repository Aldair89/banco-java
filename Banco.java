
package com.mycompany.banco;
import java.util.Scanner;

public class Banco {
    private String[][] datosClientes;
    private int numClientes;
    private int numCuentas;

    public Banco(int numClientes, int numCuentas) {
        this.numClientes = numClientes;
        this.numCuentas = numCuentas;
        datosClientes = new String[numClientes][numCuentas + 2];
    }

    public void agregarCliente(int indiceCliente, String nombre, String apellido, String[] cuentas) {
        datosClientes[indiceCliente][0] = nombre;
        datosClientes[indiceCliente][1] = apellido;

        for (int i = 0; i < numCuentas; i++) {
            datosClientes[indiceCliente][i + 2] = cuentas[i];
        }
    }

    public void mostrarDatosClientes() {
        for (int i = 0; i < numClientes; i++) {
            System.out.println("Cliente " + (i + 1) + ":");
            System.out.println("Nombre: " + datosClientes[i][0]);
            System.out.println("Apellido: " + datosClientes[i][1]);

            System.out.println("Cuentas:");
            for (int j = 0; j < numCuentas; j++) {
                System.out.println("Cuenta " + (j + 1) + ": " + datosClientes[i][j + 2]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de clientes: ");
        int numClientes = scanner.nextInt();

        System.out.print("Ingrese el número de cuentas por cliente: ");
        int numCuentas = scanner.nextInt();

        Banco banco = new Banco(numClientes, numCuentas);

        for (int i = 0; i < numClientes; i++) {
            scanner.nextLine(); // Consumir el salto de línea pendiente

            System.out.println("\nIngresando datos del cliente " + (i + 1) + ":");
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del cliente: ");
            String apellido = scanner.nextLine();

            String[] cuentas = new String[numCuentas];
            for (int j = 0; j < numCuentas; j++) {
                System.out.print("Ingrese el número de cuenta " + (j + 1) + ": ");
                cuentas[j] = scanner.nextLine();
            }

            banco.agregarCliente(i, nombre, apellido, cuentas);
        }

        System.out.println("\nDatos de los clientes:");
        banco.mostrarDatosClientes();
    }
}
