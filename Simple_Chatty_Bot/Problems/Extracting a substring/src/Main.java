import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String word = sc.nextLine();
            if(word == "Java")
                System.out.println(true);
            else
                System.out.println(false);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}