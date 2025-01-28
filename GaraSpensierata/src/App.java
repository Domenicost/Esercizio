import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("--------------------------------");
        System.out.println("GARA SPENSIERATA");
        System.out.println("--------------------------------");

        // Richiedi il numero di elementi nel percorso
        System.out.print("Inserisci il numero di elementi del percorso: ");
        int numeroElementi = scanner.nextInt();

        // Tipi di ostacoli e azioni possibili
        String[] ostacolo = { "strada", "buca", "muro", "piscina" };
        String[] azione = { "corri", "salta", "arrampicati", "nuota" };

        // Mappa ostacolo -> azione corretta
        Map<String, String> azioneCorretta = new HashMap<>();
        azioneCorretta.put("strada", "corri");
        azioneCorretta.put("buca", "salta");
        azioneCorretta.put("muro", "arrampicati");
        azioneCorretta.put("piscina", "nuota");

        // Genera il percorso casuale
        String[] percorso = new String[numeroElementi];
        for (int i = 0; i < numeroElementi; i++) {
            percorso[i] = ostacolo[random.nextInt(ostacolo.length)];
        }

        // Stampa il percorso
        System.out.println("\nEcco il percorso: " + Arrays.toString(percorso));

        // Struttura corridori: [progressi, turni, idCorridore]
        int[][] corridore = new int[5][3];
        ArrayList<String>[] storicoAzioni = new ArrayList[5];

        for (int i = 0; i < 5; i++) {
            corridore[i][2] = i + 1; // ID del corridore
            storicoAzioni[i] = new ArrayList<>();
        }

        int nTurno = 1;

        // Simulazione della gara
        while (Arrays.stream(corridore).anyMatch(c -> c[0] < numeroElementi)) {

            // Stampiamo il turno
            System.out.println("\nTurno " + nTurno + ":");
            nTurno++;

            for (int i = 0; i < 5; i++) {
                if (corridore[i][0] < numeroElementi) {
                    String ostacoloCorrente = percorso[corridore[i][0]];
                    String azioneScelta = azione[random.nextInt(azione.length)];

                    // Trasforma in maiuscolo se l'azione è corretta
                    String azioneVisualizzata = azioneScelta.equals(azioneCorretta.get(ostacoloCorrente)) ? azioneScelta.toUpperCase() : azioneScelta;

                    // Aggiungi l'azione allo storico
                    storicoAzioni[i].add("\"" + azioneVisualizzata + "\"");

                    // Verifica se l'azione è corretta
                    if (azioneScelta.equals(azioneCorretta.get(ostacoloCorrente))) {
                        corridore[i][0]++; // Incrementa i progressi
                    }

                    corridore[i][1]++; // Incrementa i turni di questo corridore
                }

                // Stampa lo stato del corridore
                System.out.println("Giocatore " + corridore[i][2] + ": " + storicoAzioni[i] + " - Ostacoli Superati: " + corridore[i][0]);
            }
        }

        // Ordina i corridori in base ai turni impiegati
        Arrays.sort(corridore, (a, b) -> Integer.compare(a[1], b[1]));

        // Mostra la classifica finale
        System.out.println("\nClassifica finale:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "° posto: Corridore " + corridore[i][2] + " con " + corridore[i][1] + " turni.");
        }

        scanner.close();
    }
}