import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(j > i)
                    System.out.print(j - i + " ");
                else
                    System.out.print(i - j + " ");
            }
        }

    }
}