
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatrixOperationsTest {
    private MatrixOperations matrixOps;
    private int[][] A;
    private int[][] B;
    private int[][] result;

    @BeforeEach
    void setUp() {
        matrixOps = new MatrixOperations();
        A = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        B = new int[][] {
                {25, 24, 23, 22, 21},
                {20, 19, 18, 17, 16},
                {15, 14, 13, 12, 11},
                {10, 9, 8, 7, 6},
                {5, 4, 3, 2, 1}
        };
        result = new int[5][5];
    }

    private void assertMatrixEquals(int[][] expected, int[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j], "Matrices no son iguales en la posición [" + i + "][" + j + "]");
            }
        }
    }

    @Test
    void testSuma() {
        matrixOps.suma(A, B, result);
        int[][] expected = {
                {26, 26, 26, 26, 26},
                {26, 26, 26, 26, 26},
                {26, 26, 26, 26, 26},
                {26, 26, 26, 26, 26},
                {26, 26, 26, 26, 26}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    void testResta() {
        matrixOps.resta(A, B, result);
        int[][] expected = {
                {-24, -22, -20, -18, -16},
                {-14, -12, -10, -8, -6},
                {-4, -2, 0, 2, 4},
                {6, 8, 10, 12, 14},
                {16, 18, 20, 22, 24}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    void testProducto() {
        matrixOps.producto(A, B, result);
        int[][] expected = {
                {175, 160, 145, 130, 115},
                {550, 510, 470, 430, 390},
                {925,860,795,730,665},
                {1300,1210,1120,1030,940},
                {1675,1560,1445,1330,1215}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    void testDivision() {
        matrixOps.division(A, B, result);
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {1, 1, 2, 2, 3},
                {4, 5, 7, 12, 25}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    void testEscalar() {
        matrixOps.escalar(A, 2, result);
        int[][] expected = {
                {2, 4, 6, 8, 10},
                {12, 14, 16, 18, 20},
                {22, 24, 26, 28, 30},
                {32, 34, 36, 38, 40},
                {42, 44, 46, 48, 50}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    void testTranspuesta() {
        matrixOps.transpuesta(A, result);
        int[][] expected = {
                {1, 6, 11, 16, 21},
                {2, 7, 12, 17, 22},
                {3, 8, 13, 18, 23},
                {4, 9, 14, 19, 24},
                {5, 10, 15, 20, 25}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    void testSimetrica() {
        int[][] symmetricMatrix = {
                {1, 2, 3, 4, 5},
                {2, 6, 7, 8, 9},
                {3, 7, 10, 11, 12},
                {4, 8, 11, 13, 14},
                {5, 9, 12, 14, 15}
        };
        assertEquals(1, matrixOps.simetrica(symmetricMatrix));

        int[][] nonSymmetricMatrix = {
                {1, 2, 3, 4, 5},
                {2, 6, 7, 8, 9},
                {3, 7, 10, 11, 12},
                {4, 8, 11, 13, 14},
                {5, 9, 12, 13, 15}
        };
        assertEquals(0, matrixOps.simetrica(nonSymmetricMatrix));
    }
}
