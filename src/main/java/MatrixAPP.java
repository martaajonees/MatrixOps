import java.util.Scanner;

public class MatrixAPP {
    private static final int SIZE = 5;

    public static void main(String[] args) {
        int opcion;
        int[][] A = new int[SIZE][SIZE];
        int[][] B = new int[SIZE][SIZE];
        int[][] R = new int[SIZE][SIZE];

        int escala;

        System.out.println("Bienvenido a la calculadora de matrices 5x5");

        //cargarMatrizDesdeArchivo(A)
        //mostrarMatriz(A);
        //cargarMatrizDesdeArchivo(B);
        //mostrarMatriz(B);

        Scanner sc = new Scanner(System.in);

        do {
            //mostrarMenuBienvenida();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    //mostrarMatriz(A);
                    //mostrarMatriz(B);
                    //suma(A,B,R);
                    //mostrarMatriz(R)
                    //registrarOperacion("Suma");
                    break;
                case 2:
                    //mostrarMatriz(A);
                    //mostrarMatriz(B);
                    //resta(A, B, R);
                    //mostrarMatriz(R);
                    //registrarOperacion("Resta");
                    break;

                case 3:
                    //mostrarMatriz(A);
                    //mostrarMatriz(B);
                    //producto(A, B, R);
                    //mostrarMatriz(R);
                    //registrarOperacion("Producto");
                    break;

                case 4:
                    //mostrarMatriz(A);
                    //mostrarMatriz(B);
                    //division(A,B,R);
                    //mostrarMatriz(R);
                    //registrarOperacion("División");
                    break;

                case 5:
                    System.out.println("Introduzca el factor de escala: ");
                    escala = sc.nextInt();
                    //mostrarMatriz(A);
                    //escalar(A, escala, R);
                    //mostrarMatriz(R);
                    //registrarOperacion("Escalar");
                    break;

                case 6:
                    //mostrarMatriz(A);
//                    if (simetrica(A)) {
//                        System.out.println("La matriz es simétrica");
//                    } else {
//                        System.out.println("La matriz no es simétrica");
//                    }
//                    registrarOperacion("Simétrica");
                    break;

                case 7:
                    //mostrarMatriz(A);
                    //transpuesta(A, R);
                    //mostrarMatriz(R);
                    //registrarOperacion("Traspuesta");
                    break;

                case 8:
                    //guardarMatrizEnArchivo(R);
                    //registrarOperacion("Guardar Matriz Resultado");
                    break;

                case 9:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while(opcion != 9);
    }
}
