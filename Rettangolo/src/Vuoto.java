import java.util.Scanner;

public class Vuoto {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Chiede la base del rettangolo
        System.out.print("Inserisci la base del rettangolo: ");
        int base = sc.nextInt();

        // Chiede l'altezza del rettangolo
        System.out.print("Inserisci l'altezza del rettangolo: ");
        int altezza = sc.nextInt();

        System.out.println("Ecco il rettangolo:");

        for (int i = 0; i < altezza; i++) {
            for (int j = 0; j < base; j++) {
                if (i == 0 || i == altezza - 1 || j == 0 || j == base - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
