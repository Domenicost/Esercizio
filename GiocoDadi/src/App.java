import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        double saldo = 100.0; // Saldo iniziale dell'utente
        boolean giocareAncora = true;

        System.out.println("-------------------------------");
        System.out.println("Benvenuto al gioco dei dadi!");
        System.out.println("-------------------------------");
        System.out.println("Saldo attuale: " + saldo + "€");

        while (giocareAncora && saldo > 0) {
            System.out.print("Quanto vuoi puntare? (min 1€): ");
            double puntata = scanner.nextDouble();

            // Controllo della puntata valida
            while (puntata <= 0 || puntata > saldo) {
                System.out.print("Puntata non valida. Inserisci un importo valido: ");
                puntata = scanner.nextDouble();
            }

            int puntiUtente = 0;
            int puntiComputer = 0;

            // Generazione 3 turni di gioco
            for (int turno = 1; turno <= 3; turno++) {
                System.out.println("\nTurno " + turno + ":");
                int lancioUtente1 = random.nextInt(6) + 1;
                int lancioUtente2 = random.nextInt(6) + 1;
                int totaleUtente = lancioUtente1 + lancioUtente2;

                int lancioComputer1 = random.nextInt(6) + 1;
                int lancioComputer2 = random.nextInt(6) + 1;
                int totaleComputer = lancioComputer1 + lancioComputer2;

                System.out.println("Lanci utente: " + lancioUtente1 + " e " + lancioUtente2 + " (Totale: " + totaleUtente + ")");
                System.out.println("Lanci computer: " + lancioComputer1 + " e " + lancioComputer2 + " (Totale: " + totaleComputer + ")");

                if (totaleUtente > totaleComputer) {
                    puntiUtente++;
                    System.out.println("Hai vinto questo turno!");
                } else if (totaleUtente < totaleComputer) {
                    puntiComputer++;
                    System.out.println("Il computer ha vinto questo turno!");
                } else {
                    System.out.println("Pareggio!");
                }
            }

            // Determinazione del vincitore
            System.out.println("\nPunteggio finale: Utente " + puntiUtente + " - Computer " + puntiComputer);
            if (puntiUtente > puntiComputer) {
                System.out.println("Complimenti! Hai vinto la partita e guadagnato: " + puntata + "€.");
                saldo += puntata; // Guadagno
            } else if (puntiUtente < puntiComputer) {
                System.out.println("Il computer ha vinto la partita e hai perso: " + puntata + "€.");
                saldo -= puntata; // Perdita
            } else {
                System.out.println("La partita è finita in pareggio.");
                // Il saldo non cambia
            }

            // Controllo del saldo e possibilità di giocare ancora
            if (saldo > 0) {
                System.out.print("\nHai " + saldo + "€." +" Vuoi giocare un'altra partita? (y/n): ");
                String risposta = scanner.next();
                giocareAncora = risposta.equalsIgnoreCase("y");
            } else {
                System.out.println("\nSaldo esaurito. Non puoi più giocare.");
                giocareAncora = false;
            }
        }

        System.out.println("\nEsci con: " + saldo + "€. Grazie per aver giocato!");
        scanner.close();
    }
}