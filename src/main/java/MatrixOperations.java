
public class MatrixOperations {
    private static final int N = 5;

    public void suma(int[][] A, int[][] B, int[][] R){
        for(int i=0; i < N; i++){
            for (int j = 0; j < N; j++){
                R[i][j] = A[i][j] + B[i][j];
            }
        }
    }

    public void resta(int[][] A, int[][] B, int[][] R) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[i][j] - B[i][j];
            }
        }
    }

    public void producto(int[][] A, int[][] B, int[][] R) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = 0;
                for (int k = 0; k < N; k++) {
                    R[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    public void division(int[][] A, int[][] B, int[][] R) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[i][j] / B[i][j];
            }
        }
    }

    public void escalar(int[][] A, int escalar, int[][] R) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[i][j] * escalar;
            }
        }
    }

    public void transpuesta(int[][] A, int[][] R) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = A[j][i];
            }
        }
    }

    public int simetrica(int[][] A) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] != A[j][i]) {
                    return 0; // No es simétrica
                }
            }
        }
        return 1;
    }

}
