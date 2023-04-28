import java.util.Objects;

public class MySparseMatrix {
    private final double[][] matrix;

    public MySparseMatrix(double[][] A) {
        int B = A.length;
        this.matrix = new double[B][B];
        for(int i = 0; i < B; i++) {
            for(int j = 0; j < B; j++) {
                this.matrix[j][i] = A[i][j];
            }
        }
    }
}
