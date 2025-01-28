import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // Lista iniziale di buoni propositi
        ArrayList<String> buoniPropositi = new ArrayList<>();
        buoniPropositi.add("Fare più attività fisica");
        buoniPropositi.add("Esercitarsi su Java");
        buoniPropositi.add("Leggere almeno 10 libri");
        buoniPropositi.add("Risparmiare più soldi");
        buoniPropositi.add("Migliorare la dieta alimentare");

        System.out.println("--------------------------------");
        System.out.println("BUONI PROPOSITI");
        System.out.println("--------------------------------\n");

        while (!buoniPropositi.isEmpty()) {

            /* Caso in cui rimane un solo proposito.
            Non richiesto ma mi sembrava un buon punto di chiusura dato che
            nella maggior parte dei casi non tutti i buoni propositi vengono completati.

            Per essere più pignoli, sarebbe stato meglio far interrompere il ciclo all'utente.  
            */

            if (buoniPropositi.size() == 1) {
                System.out.println("Rimane solo: " + buoniPropositi.get(0));
                System.out.print("Lo hai completato? (y/n): ");
                String risposta = scanner.nextLine().trim().toLowerCase();

                if (risposta.equals("y")) {
                    System.out.println("\nPerfetto! Hai completato tutti i tuoi buoni propositi!");
                    break;
                } else {
                    System.out.println("\nContinua a lavorarci su!");
                    System.out.println("\n\u001B[3mRicorda: Non è un fallimento, ma un passo verso la crescita!\u001B[0m");
                    break;
                }
            }

            // Visualizza i buoni propositi rimanenti
            System.out.println("Ecco la tua lista:\n");
            for (int i = 0; i < buoniPropositi.size(); i++) {
                System.out.println((i + 1) + ". " + buoniPropositi.get(i));
            }

            // Chiede all'utente quale proposito ha completato
            System.out.print("\nQuale hai completato? (Inserisci il numero): ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta < 1 || scelta > buoniPropositi.size()) {
                System.out.println("\nScelta non valida. Riprova.\n");
                continue;
            }

            // Rimuove quello completato
            String completato = buoniPropositi.remove(scelta - 1);
            System.out.println("Complimenti per aver completato: " + completato + "!\n");

        }

        System.out.println("\nGrazie per aver utilizzato il mio programma!!");
        scanner.close();
    }
}