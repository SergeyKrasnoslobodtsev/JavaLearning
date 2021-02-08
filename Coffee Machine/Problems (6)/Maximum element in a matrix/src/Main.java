import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt ();
        int m = scanner.nextInt ();
        int [] [] matrix = new int [n] [m];
        for (int i = 0; i <n; i ++) {
            for (int j = 0; j <m; j ++) {
                matrix [i] [j] = scanner.nextInt ();
            }
        }
        int maximum = matrix [0] [0];
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        for (int i = 0; i <n; i ++) {
            for (int j = 0; j <m; j ++) {
                if (matrix [i] [j]> maximum)
                {
                    maximum = matrix [i] [j] ;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println (x + "" + y); }
    }
}
