import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> elenco = new HashMap<>();
        boolean continua = true;

        while (continua) {
            System.out.print("Inserisci il limite di velocità della strada (km/h): ");
            int limiteVelocita = scanner.nextInt();

            System.out.print("Inserisci la velocità rilevata (km/h): ");
            int velocitaRilevata = scanner.nextInt();

            System.out.print("Inserisci la targa dell'automobile: ");
            String targa = scanner.next();

            int differenza = velocitaRilevata - limiteVelocita;
            int sanzione = 0;

            if (differenza <= 5) {
                sanzione = 0;
            } else if (differenza <= 10) {
                sanzione = 60;
            } else if (differenza <= 30) {
                sanzione = 200;
            } else if (differenza <= 50) {
                sanzione = 500;
            } else {
                sanzione = 1000;
            }

            if (elenco.containsKey(targa)) {
                elenco.put(targa, elenco.get(targa) + sanzione);
            } else {
                elenco.put(targa, sanzione);
            }

            System.out.println("\nTarga: " + targa);
            System.out.println("Velocità rilevata: " + velocitaRilevata + " km/h");
            System.out.println("Limite di velocità: " + limiteVelocita + " km/h");
            System.out.println("Importo sanzione: " + sanzione + " euro\n");

            System.out.print("Vuoi eseguire un nuovo rivelamento? (s/n): ");
            String risposta = scanner.next().toLowerCase();
            if (!risposta.equals("s")) {
                continua = false;
            }
        }

        System.out.println("\nElenco delle sanzioni:");
        for (Entry<String, Integer> e : elenco.entrySet()) {
            System.out.println("Targa: " + e.getKey() + ", Sanzioni: " + e.getValue() + " euro");
        }

        scanner.close();
    }
}
