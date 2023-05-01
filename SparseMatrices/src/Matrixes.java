import java.util.Random;


public class Matrixes {

    public static double[][] matrixDenseRow(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = getRandomDouble();
            }
        }
        return matrix;
    }

    public static double[][] matrixDenseCol(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[j][i] = getRandomDouble();
            }
        }
        return matrix;
    }

    public static double[][] matrixBandRow(int size, int band) {
        double[][] matrix2 = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = Math.max(0, i - band); j < Math.min(size, i + band + 1); j++) {
                matrix2[i][j] = getRandomDouble();
            }
        }
        return matrix2;
    }

    public static double[][] matrixBandCol(int size, int band) {
        double[][] matrixA = new double[size][size];
        for (int j = 0; j < size; j++) {
            for (int i = Math.max(0, j - band); i <= j; i++) {
                matrixA[i][j] = getRandomDouble();
            }
        }
        return matrixA;
    }

    public static double[][] sparseRandomMatrixRow(int size, double density) {
        double[][] matrix = new double[size][size];
        int maxNonZeroElements = (int) Math.round(density * size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            matrix[i][i] = getRandomDouble();
            int numNonZeroElements = random.nextInt(maxNonZeroElements + 1);
            for (int j = 0; j < numNonZeroElements; j++) {
                int col = random.nextInt(size);
                if (col != i) {
                    matrix[i][col] = getRandomDouble();
                }
            }
        }
        return matrix;
    }

    public static double[][] sparseRandomMatrixCol(int size, double density) {
        double[][] matrix = new double[size][size];
        int maxNonZeroElements = (int) Math.round(density * size);
        Random random = new Random();
        for (int j = 0; j < size; j++) {
            matrix[j][j] = getRandomDouble();
            int numNonZeroElements = random.nextInt(maxNonZeroElements + 1);
            for (int i = 0; i < numNonZeroElements; i++) {
                int row = random.nextInt(size);
                if (row != j) {
                    matrix[row][j] = getRandomDouble();
                }
            }
        }
        return matrix;
    }


    private static double getRandomDouble() {
        Random random = new Random();
        double max = Math.pow(2, 16) - 1;
        double min = -Math.pow(2, 16);
        double randomNumber = ((random.nextDouble() * (max - min)) + min);
        return randomNumber / Math.pow(2, 16);
    }
}
