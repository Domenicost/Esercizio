import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App_v2 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> elenco = new HashMap<>();
        boolean continua = true;

        Map<Integer, Integer> mappaSanzioni = new LinkedHashMap<>();
        mappaSanzioni.put(5, 0);
        mappaSanzioni.put(10, 60);
        mappaSanzioni.put(30, 200);
        mappaSanzioni.put(50, 500);
        mappaSanzioni.put(51, 1000);

        while (continua) {
            System.out.print("Inserisci il limite di velocità della strada (km/h): ");
            int limiteVelocita = scanner.nextInt();

            System.out.print("Inserisci la velocità rilevata (km/h): ");
            int velocitaRilevata = scanner.nextInt();

            System.out.print("Inserisci la targa dell'automobile: ");
            String targa = scanner.next();

            int differenza = velocitaRilevata - limiteVelocita;
            int sanzione = 0;

            for (Map.Entry<Integer, Integer> e : mappaSanzioni.entrySet()) {
                if (differenza <= e.getKey()) {
                    sanzione = e.getValue();
                    break;
                }
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
        for (Map.Entry<String, Integer> e : elenco.entrySet()) {
            System.out.println("Targa: " + e.getKey() + ", Sanzioni: " + e.getValue() + " euro");
        }

        scanner.close();
    }
}
