import java.util.Scanner;

class Main {

    static void transpose(int mat[][], int tr[][], int N)
    {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                tr[i][j] = mat[j][i];
    }

    // Returns true if mat[N][N] is symmetric, else false
    static boolean isSymmetric(int mat[][], int N)
    {
        int tr[][] = new int[N][N];
        transpose(mat, tr, N);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (mat[i][j] != tr[i][j])
                    return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var matrix = new int [n] [n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                matrix [i] [j] = scanner.nextInt ();
            }
        }

        if (isSymmetric(matrix, n))
            System.out.println( "YES");
        else
            System.out.println ( "NO");

    }
}