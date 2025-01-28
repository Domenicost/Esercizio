import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        // Chiede all'utente il numero
        System.out.print("Inserisci un numero: ");
        int numeroMax = scanner.nextInt();

       // Gira fino a numeroMax
        for (int numero = 2; numero <= numeroMax; numero++) {
            boolean primo = true;
        
            // Controlla se il numero è divisibile per altri numeri
            for (int divisore = 2; divisore <= numero / 2; divisore++) {
                if (numero % divisore == 0) {
                    primo = false;
                }
            }
        
            if (primo) {
                numeriPrimi.add(numero);
            }
        }

        System.out.println("\nI numeri primi tra 1 e " + numeroMax + " sono: " + numeriPrimi.toString());

        scanner.close();
    }
}