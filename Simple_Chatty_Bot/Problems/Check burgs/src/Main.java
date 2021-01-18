import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String city = sc.nextLine();
            if(city.length() > 4)
                System.out.println(city.endsWith("burg"));
            else
                System.out.println(false);

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}