package uca.mps.service;

import org.springframework.stereotype.Service;

@Service
public class MatrixOperations {
    private static final int N = 5;

    public int[][] suma(int[][] A, int[][] B){
        int[][] R = new int[N][N];
        for(int i=0; i < N; i++){
            for (int j = 0; j < N; j++){
                R[i][j] = A[i][j] + B[i][j];
            }
        }
        return R;
    }

    public int[][] resta(int[][] A, int[][] B) {
        int[][] R = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[i][j] - B[i][j];
            }
        }
        return R;
    }

    public int[][] producto(int[][] A, int[][] B) {
        int[][] R = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = 0;
                for (int k = 0; k < N; k++) {
                    R[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return R;
    }

    public int[][] division(int[][] A, int[][] B) {
        int[][] R = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[i][j] / B[i][j];
            }
        }
        return R;
    }

    public int[][] escalar(int[][] A, int escalar) {
        int[][] R = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[i][j] * escalar;
            }
        }
        return R;
    }

    public int[][] transpuesta(int[][] A) {
        int[][] R = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[j][i];
            }
        }
        return R;
    }

    public boolean simetrica(int[][] A) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] != A[j][i]) {
                    return false; // No es simétrica
                }
            }
        }
        return true;
    }

}
