package com.uca.mps.MatrixPro.App;

import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Service
public class IOMatrix {

    private static final int TAMANO_MATRIZ = 5;

    // Muestra el menú de bienvenida
    public static void mostrarMenuBienvenida() {
        System.out.println("\n--- Calculadora de Matrices 5x5 ---");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Sumar matrices");
        System.out.println("2. Restar matrices");
        System.out.println("3. Producto matrices");
        System.out.println("4. División matrices");
        System.out.println("5. Producto escalar matrices");
        System.out.println("6. Matriz simétrica");
        System.out.println("7. Matriz traspuesta");
        System.out.println("8. Guardar matriz en archivo");
        System.out.println("9. Salir");
    }

    // Cargar datos en una matriz desde la consola
    public static void cargarMatrizConsola(int[][] mat) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                mat[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    // Mostrar una matriz en la consola
    public static void mostrarMatriz(int[][] mat) {
        for (int[] fila : mat) {
            for (int valor : fila) {
                System.out.printf("%4d ", valor);
            }
            System.out.println();
        }
    }

    // Cargar una matriz desde un archivo
    public static boolean cargarMatrizArchivo(int[][] mat) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del archivo para cargar la matriz: ");
        String nombreArchivo = scanner.nextLine();
        scanner.close();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            for (int i = 0; i < TAMANO_MATRIZ; i++) {
                String[] valores = reader.readLine().split("\\s+");
                for (int j = 0; j < TAMANO_MATRIZ; j++) {
                    mat[i][j] = Integer.parseInt(valores[j]);
                }
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            gestionarError("Error al cargar la matriz desde el archivo: " + e.getMessage());
            return false;
        }
    }

    // Guardar una matriz en un archivo
    public static boolean guardarMatrizArchivo(int[][] mat) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del archivo para guardar la matriz: ");
        String nombreArchivo = scanner.nextLine();
        scanner.close();
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (int[] fila : mat) {
                for (int valor : fila) {
                    writer.print(valor + " ");
                }
                writer.println();
            }
            return true;
        } catch (IOException e) {
            gestionarError("Error al guardar la matriz en el archivo: " + e.getMessage());
            return false;
        }
       
    }

    // Registrar una operación en el log
    public static boolean registrarOperacion(String operacion) {
        String logFileName = "log_operaciones.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFileName, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String timestamp = dateFormat.format(new Date());
            writer.println("[" + timestamp + "] " + operacion);
            return true;
        } catch (IOException e) {
            gestionarError("Error al registrar la operación: " + e.getMessage());
            return false;
        }
    }

    // Manejar errores
    public static void gestionarError(String mensajeError) {
        System.err.println("ERROR: " + mensajeError);
        System.exit(1);
    }
}
