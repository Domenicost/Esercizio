import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numeriEstratti = new ArrayList<>(); // Lista per memorizzare i numeri estratti

        System.out.println("\n--------------------------------");
        System.out.println("GIOCO DELLA TOMBOLA!");
        System.out.println("--------------------------------\n");

        // Chiedo all'utente quante cartelle vuole acquistare
        System.out.print("Quante cartelle vuoi comprare? ");
        int numeroCartelle = scanner.nextInt();
        ArrayList<ArrayList<Integer>> cartelle = new ArrayList<>();

        // Genero le cartelle con 15 numeri diversi ciascuna
        for (int i = 0; i < numeroCartelle; i++) {
            ArrayList<Integer> scheda = new ArrayList<>();
            while (scheda.size() < 15) {
                int numero = random.nextInt(90) + 1;
                if (!scheda.contains(numero)) {
                    scheda.add(numero);
                }
            }
            cartelle.add(scheda);
            System.out.println("Cartella " + (i + 1) + ": " + scheda);
        }

        boolean amboFatto = false; 
        boolean ternoFatto = false; 
        boolean quaternaFatto = false;
        boolean cinquinaFatto = false; 
        boolean tombola = false;

        // Estrazione dei 90 numeri
        while (numeriEstratti.size() < 90 && !tombola) {
            int numero;

            // Controllo se il numero è già stato estratto
            do {
                numero = random.nextInt(90) + 1;
            } while (numeriEstratti.contains(numero));

            // Aggiungo il numero alla lista dei numeri estratti e lo stampo
            numeriEstratti.add(numero);
            System.out.println("\nNumero estratto: " + numero);

            // Controllo ogni cartella
            for (int i = 0; i < cartelle.size(); i++) {
                ArrayList<Integer> scheda = cartelle.get(i);
                int numeriCorrispondenti = 0;

                System.out.print("Cartella " + (i + 1) + " aggiornata: ");
                for (int n : scheda) {
                    if (numeriEstratti.contains(n)) {
                        System.out.print("[" + n + "] ");
                        numeriCorrispondenti++;
                    } else {
                        System.out.print(n + " ");
                    }
                }
                System.out.println();
                
                // Dentro il ciclo di estrazione
                if (numeriCorrispondenti >= 2 && !amboFatto) {
                    System.out.println("\n--------------------------------");
                    System.out.println("Cartella " + (i + 1) + " ha fatto AMBO!");
                    System.out.println("--------------------------------\n");
                    amboFatto = true; // Blocca ulteriori Ambo
                }
                
                if (numeriCorrispondenti >= 3 && !ternoFatto) {
                    System.out.println("\n--------------------------------");
                    System.out.println("Cartella " + (i + 1) + " ha fatto TERNO!");
                    System.out.println("--------------------------------\n");
                    ternoFatto = true; // Blocca ulteriori Terni
                }
                
                if (numeriCorrispondenti >= 4 && !quaternaFatto) {
                    System.out.println("\n--------------------------------");
                    System.out.println("Cartella " + (i + 1) + " ha fatto QUATERNA!");
                    System.out.println("--------------------------------\n");
                    quaternaFatto = true; // Blocca ulteriori Quaterne
                }
                
                if (numeriCorrispondenti >= 5 && !cinquinaFatto) {
                    System.out.println("\n--------------------------------");
                    System.out.println("Cartella " + (i + 1) + " ha fatto CINQUINA!");
                    System.out.println("--------------------------------\n");
                    cinquinaFatto = true; // Blocca ulteriori Cinquine
                }
                
                if (numeriCorrispondenti == 15) {
                    System.out.println("\n--------------------------------");
                    System.out.println("Cartella " + (i + 1) + " ha fatto TOMBOLA!");
                    System.out.println("--------------------------------\n");
                    tombola = true;
                    break; // Fine della partita
                }                
            }
        }

        System.out.println("Fine! Grazie per aver giocato!");
        scanner.close();
    }
}
