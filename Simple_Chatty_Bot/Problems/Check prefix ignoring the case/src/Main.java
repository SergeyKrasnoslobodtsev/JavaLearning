import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String word = sc.nextLine();
            char letter = word.toUpperCase().charAt(0);
            if(letter == 'J')
                System.out.println(true);
            else
                System.out.println(false);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}