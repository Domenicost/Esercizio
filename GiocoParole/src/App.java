import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Array di parole tra cui scegliere
        String[] parole = { "mare", "riso", "pane", "sale", "aria", "sole", "orto", "cane", "fiore", "rete" };

        // Lettura del file di parole
        String nomeFile = "110000_parole_italiane_con_nomi_propri.txt";

        ArrayList<String> paroleAmmesse = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(nomeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String riga;

            while ((riga = bufferedReader.readLine()) != null)
                paroleAmmesse.add(riga.trim());

            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }

        // ArrayList per memorizzare le risposte dei giocatori
        ArrayList<String> rGiocatore1 = new ArrayList<>();
        ArrayList<String> rGiocatore2 = new ArrayList<>();
        ArrayList<String> tRisposte = new ArrayList<>();

        // Array per memorizzare il tempo impiegato dai giocatori
        long[] tGiocatore1 = new long[5];
        long[] tGiocatore2 = new long[5];

        // Inizio Partita
        System.out.println("--------------------------------");
        System.out.println("BENVENUTO NELLA PARTITA!");
        System.out.println("--------------------------------");

        // Gira per 5 turni
        for (int i = 1; i <= 5; i++) {
            System.out.println("Turno " + i);

            // Gira per 2 giocatori
            for (int giocatore = 1; giocatore <= 2; giocatore++) {

                // Selezione casuale di una parola
                int indiceCasuale = random.nextInt(parole.length);
                String parolaEstratta = parole[indiceCasuale];
                System.out.println("\nGiocatore " + giocatore);
                System.out.println("La parola è " + parolaEstratta);

                // Richiesta input all'utente
                System.out.print("Inserisci la tua risposta (Hai 10 secondi): ");

                // Risposta + Calcolo del tempo
                long inizioTempo = System.currentTimeMillis();
                String risposta = scanner.nextLine();
                long fineTempo = System.currentTimeMillis();
                long secondiTrascorsi = (fineTempo - inizioTempo) / 1000;

                // Aggiunta del tempo nel rispettivo Array del giocatore
                (giocatore == 1 ? tGiocatore1 : tGiocatore2)[i - 1] = secondiTrascorsi;

                // Verifica della risposta
                if (risposta.indexOf(parolaEstratta) != -1 && !risposta.equals(parolaEstratta) && secondiTrascorsi < 10
                        && paroleAmmesse.contains(risposta) && !tRisposte.contains(risposta)) {
                    System.out.println("\nCorretto!\n");
                    (giocatore == 1 ? rGiocatore1 : rGiocatore2).add(risposta); // Aggiunta della risposta all'Array del
                                                                                // giocatore
                    tRisposte.add(risposta); // Aggiunta riposta all'array generico
                } else if (risposta.equals(parolaEstratta)) {
                    System.out.println("\nSbagliato! La parola non può essere uguale alla parola estratta.\n");
                } else if (secondiTrascorsi > 10 && paroleAmmesse.contains(risposta)) {
                    System.out.println(
                            "\nTempo scaduto! Hai impiegato " + secondiTrascorsi + " secondi. Risposta non valida.\n");
                    tRisposte.add(risposta);
                } else if (tRisposte.contains(risposta)) {
                    System.out.println("\nSbagliato! Parola già inserita.\n");
                } else {
                    System.out.println("\nParola non valida.\n");
                }
            }
        }

        scanner.close();

        System.out.println("--------------------------------");
        System.out.println("FINE PARTITA!");
        System.out.println("--------------------------------\n");

        // Calcolo del tempo impiegato dai giocatori
        long sommaTempiGiocatore1 = 0;
        long sommaTempiGiocatore2 = 0;

        for (int sommaTempi = 0; sommaTempi < tGiocatore1.length; sommaTempi++) {
            sommaTempiGiocatore1 += tGiocatore1[sommaTempi];
            sommaTempiGiocatore2 += tGiocatore2[sommaTempi];
        }

        // Verifica del vincitore
        if (rGiocatore1.size() > 0 || rGiocatore2.size() > 0) {
            if (rGiocatore1.size() > rGiocatore2.size()) {
                System.out.println("Giocatore 1 Ha vinto! Risposte: " + rGiocatore1.toString());
                System.out.println("Giocatore 2 Ha Perso! Risposte: " + rGiocatore2.toString());
            } else if (rGiocatore2.size() > rGiocatore1.size()) {
                System.out.println("Giocatore 2 Ha vinto! Risposte: " + rGiocatore2.toString());
                System.out.println("Giocatore 1 Ha Perso! Risposte: " + rGiocatore1.toString());
            } else if (sommaTempiGiocatore1 < sommaTempiGiocatore2) {
                System.out.println("Pareggio! Ma vince il Giocatore 1 perchè ha impiegato: " + sommaTempiGiocatore1 + " secondi");
            } else if (sommaTempiGiocatore2 < sommaTempiGiocatore1) {
                System.out.println(
                        "Pareggio! Ma vince il Giocatore 2 perchè ha impiegato: " + sommaTempiGiocatore2 + " secondi");
            } else {
                System.out.println("Pareggio! Avete impiegato lo stesso tempo nelle risposte!");
                System.out.println("Giocatore 1. Risposte: " + rGiocatore1.toString());
                System.out.println("Giocatore 2. Risposte: " + rGiocatore2.toString());
            }
        } else {
            System.out.println("Pareggio! Nessun Giocatore ha dato risposte corrette.");
        }
    }
}