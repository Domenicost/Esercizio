import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        double[] prezzi = {2.5, 3.75, 1.20, 5.00, 3.15};
        double totale = 0;
        String[] prodotti = {"Linguine", "Pane pugliese", "Caramelle", "Pomodori", "Lenticchie"};
        ArrayList<String> carrello = new ArrayList<>(); // Lista per memorizzare i prodotti acquistati
        boolean continua=true;

        int pos;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        System.out.println("Benvenuto nel nostro negozio. Sono presenti " + prezzi.length + " prodotti:");
        System.out.println("---------------------------------------------------------");
        
        // Mostra i prodotti presenti
        for (int i = 0; i < prodotti.length; i++) {
            System.out.println((i + 1) + ". " + prodotti[i] + " - " + String.format("%.2f", prezzi[i]) + "€");
        }
        
        // Inizia la spesa
        do {
            System.out.print("\nInserisci il numero del prodotto da acquistare (1-" + prezzi.length + "): ");
            pos = sc.nextInt();
            sc.nextLine();

            if (pos >= 1 && pos <= prezzi.length) {
                System.out.println(
                    "Hai aggiunto: " + prodotti[pos - 1]);
                totale += prezzi[pos - 1];
                carrello.add(prodotti[pos - 1]);
                
                // Mostra il carrello
                System.out.println("Carrello attuale: " + carrello + " - Totale: " + String.format("%.2f", totale) + "€");
            } else {
                System.out.println("Scelta non valida");
            }

            System.out.print("\nVuoi continuare (s/n)? ");
            String scelta = sc.nextLine();
            if(scelta.equals("n")){
                continua=false;            
            }
        } while (continua);

        System.out.println("Hai speso: " + String.format("%.2f", totale) + " Grazie per averci scelto"); // Formatta il totale con 2 cifre decimali

        sc.close();
    }
}
