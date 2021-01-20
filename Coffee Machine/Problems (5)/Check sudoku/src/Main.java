import java.util.*;

public class Main {
    public static boolean checkArray(int[] a) {
        int[] sampleArray = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            sampleArray[i] = i + 1;
        }

        Arrays.sort(a);

        return Arrays.equals(a, sampleArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte n = scanner.nextByte();

        int[][] t = new int[n * n][n * n];

        // Declare Standard and Test arrays
        final int[] standardArray = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            standardArray[i] = i + 1;
        }

        int[] testArray = new int[n * n];

        // getting inputs and testing each ROW
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                t[i][j] = scanner.nextInt();
                testArray[j] = t[i][j];
            }
            if ( !checkArray(testArray) ) {
                System.out.println("NO");
                return;
            }
        }

        // test each COL
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                testArray[j] = t[j][i];
            }
            if ( !checkArray(testArray) ) {
                System.out.println("NO");
                return;
            }
        }

        // check each square
        int counter = 0;

        for (int i = 0; i < n * (n - 1); i += n) {
            for (int j = 0; j < n * (n - 1); j += n) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        testArray[counter] = t[i + k][j + l];
                        counter++;
                    }
                }
                if ( !checkArray(testArray) ) {
                    System.out.println("NO");
                    return;
                } else {
                    counter = 0;
                }
            }
        }

        System.out.println("YES");
    }
}