import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int prev = sc.nextInt();
            int curr = sc.nextInt();

            boolean isResult = true;
            boolean flag = prev <= curr;
            while (sc.hasNextInt()) {
                prev = curr;
                curr = sc.nextInt();
                if ( curr != 0 ) if ( prev <= curr && flag ) {
                    isResult = true;
                } else if ( prev >= curr && !flag ) {
                    isResult = true;
                } else {
                    isResult = false;
                    break;
                }
            }
            System.out.println(isResult);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}