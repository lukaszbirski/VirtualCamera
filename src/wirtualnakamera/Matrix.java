package wirtualnakamera;

public class Matrix {

    double matrix[][];

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**Metoda przekształca zadaną macierz w macierz jednostkową*/
    public static double[][] identityMatrix() {
        double[][] mtx = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return mtx;
    }

    /**Metoda przekształca macierz jednostkową w macierz rzutowanie*/
    public static double[][] projectionMatrix(double d) {
        double[][] mtx = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1 / d, 0}
        };
        return mtx;

    }

    /***/
    public static double[][] macierzPp(double d, double z_min) {
        double[][] mtx = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1/(1-z_min), -z_min/(1-z_min)},
                {0, 0, 1 / d , 0}
        };
        return mtx;

    }

    /**Metoda przekształca macierz jednostkową w macierz translacji*/
    public static double[][] translationMatrix(double Tx, double Ty, double Tz) {
        double[][] mtx = {
                {1, 0, 0, Tx},
                {0, 1, 0, Ty},
                {0, 0, 1, Tz},
                {0, 0, 0, 1}
        };
        return mtx;
    }

    /**Metoda przekształca macierz jednostkową w macierz obrotu wg. OX. Obrót dokonywany jest o zadany kąt.*/
    public static double[][] rotationMatrixOX(double phi) {
        double[][] mtx = {
                {1, 0, 0, 0},
                {0, Math.cos(phi), -1 * Math.sin(phi), 0},
                {0, Math.sin(phi), Math.cos(phi), 0},
                {0, 0, 0, 1}
        };
        return mtx;
    }

    /**Metoda przekształca macierz jednostkową w macierz obrotu wg. OY. Obrót dokonywany jest o zadany kąt.*/
    public static double[][] rotationMatrixOY(double phi) {
        double[][] mtx = {
                {Math.cos(phi), 0, Math.sin(phi), 0},
                {0, 1, 0, 0},
                {-1 * Math.sin(phi), 0, Math.cos(phi), 0},
                {0, 0, 0, 1}
        };
        return mtx;
    }

    /**Metoda przekształca macierz jednostkową w macierz obrotu wg. OZ. Obrót dokonywany jest o zadany kąt.*/
    public static double[][] rotationMatrixOZ(double phi) {
        double[][] mtx = {
                {Math.cos(phi), -1 * Math.sin(phi), 0, 0},
                {Math.sin(phi), Math.cos(phi), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return mtx;
    }

    /***/
    public static double[][] multiply(double a[][], double b[][]) {

        int aRows = a.length,
                aColumns = a[0].length,
                bRows = b.length,
                bColumns = b[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] resultant = new double[aRows][bColumns];

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    resultant[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return resultant;
    }
}
