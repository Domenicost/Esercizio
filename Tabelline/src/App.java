import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        String risposta="";

        do {
            System.out.print("Quale tabellina vuoi visualizzare? ");
            int n = sc.nextInt();
            sc.nextLine();
            System.out.println("Tabellina del " + n + ":");
                
            for (int i = 1; i <= 10; i++) {
                    System.out.println(n + " x " + i + " = " + (n * i));
                }

            System.out.println("Vuoi continuare? (y/n)");
            risposta = sc.nextLine();

        } while (risposta.equals("y"));

        System.out.println("Programma terminato.");
        sc.close();
    }
}