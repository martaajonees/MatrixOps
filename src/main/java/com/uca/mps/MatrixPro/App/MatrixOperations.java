package com.uca.mps.MatrixPro.App;

import org.springframework.stereotype.Service;

@Service
public class MatrixOperations {

    public int[][] suma(int[][] A, int[][] B){
        if(A.length != B.length){
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
        }

        int fila = A.length;
        int columna = A[0].length;
        int[][] R = new int[fila][columna];

        for(int i=0; i < fila; i++){
            for (int j = 0; j < columna; j++){
                R[i][j] = A[i][j] + B[i][j];
            }
        }
        return R;
    }

    public int[][] resta(int[][] A, int[][] B) {
        if(A.length != B.length){
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
        }

        int fila = A.length;
        int columna = A[0].length;
        int[][] R = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                R[i][j] = A[i][j] - B[i][j];
            }
        }
        return R;
    }

    public int[][] producto(int[][] A, int[][] B) {
        if(A[0].length != B.length){
            throw new IllegalArgumentException("El número de columnas de la matriz A debe ser igual al número de filas de la matriz B");
        }

        int fila = A.length;
        int columna = B[0].length;
        int[][] R = new int[fila][columna];
        
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                R[i][j] = 0;
                for (int k = 0; k < A[0].length; k++) {
                    R[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return R;
    }

    public int[][] division(int[][] A, int[][] B) {
        if(A[0].length != B.length){
            throw new IllegalArgumentException("El número de columnas de la matriz A debe ser igual al número de filas de la matriz B");
        }

        int fila = A.length;
        int columna = B.length;
        int[][] R = new int[fila][columna];

     
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if(B[i][j] == 0){
                    throw new IllegalArgumentException("No se puede dividir por cero");
                }
                R[i][j] = A[i][j] / B[i][j];
            }
        }
        return R;
    }

    public int[][] escalar(int[][] A, int escalar) {
        int fila = A.length;
        int columna = A[0].length;
        int[][] R = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                R[i][j] = A[i][j] * escalar;
            }
        }
        return R;
    }

    public int[][] transpuesta(int[][] A) {
        int fila = A.length;
        int columna = A[0].length;
        int[][] R = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                R[i][j] = A[j][i];
            }
        }
        return R;
    }

    public boolean simetrica(int[][] A) {
        if(A.length != A[0].length){
            return false; // No es cuadrada
        }
        int N = A.length;

        for (int fila = 0; fila < N; fila++) {
            for (int columna = 0; columna < N; columna++) {
                if (A[fila][columna] != A[columna][fila]) {
                    return false; // No es simétrica
                }
            }
        }
        return true;
    }

}
