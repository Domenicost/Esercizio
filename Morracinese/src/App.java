import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int uScore = 0;
        int pcScore = 0;

        System.out.println("\nBenvenuto a Morra Cinese!");
        System.out.println("La partita finisce alla meglio di 3");
        System.out.println("\nGioca inserendo:\n1 = Sasso\n2 = Carta\n3 = Forbice");

        do {
            // Scelta dell'utente
            System.out.print("\nTocca a te: ");
            int uScelta = scanner.nextInt();

            // Controllo numero inserito
            while (uScelta > 3 || uScelta == 0) {
                System.out.print("Mossa non valida!\nScegli il tuo segno (1, 2, 3): ");
                uScelta = scanner.nextInt();
            }

            // Scelta casuale del PC
            int pcScelta = random.nextInt(3) + 1;

            // Determinazione dei segni
            String uSegno = "";
            String pcSegno = "";

            if (uScelta == 1)
                uSegno = "Sasso";
            else if (uScelta == 2)
                uSegno = "Carta";
            else if (uScelta == 3)
                uSegno = "Forbice";

            if (pcScelta == 1)
                pcSegno = "Sasso";
            else if (pcScelta == 2)
                pcSegno = "Carta";
            else if (pcScelta == 3)
                pcSegno = "Forbice";

            // Determina l'esito del turno
            if (uScelta == pcScelta) {
                System.out.println("Pareggio! Entrambi avete scelto " + uSegno + ".");
            } else if ((uScelta == 1 && pcScelta == 3) ||
                    (uScelta == 2 && pcScelta == 1) ||
                    (uScelta == 3 && pcScelta == 2)) {
                System.out.println(uSegno + " batte " + pcSegno);
                System.out.println("Hai vinto questo turno!");
                uScore++;
            } else {
                System.out.println(pcSegno + " batte " + uSegno);
                System.out.println("Il PC ha vinto questo turno!");
                pcScore++;
            }

            // Mostra il punteggio
            System.out.println("Punteggio: Utente " + uScore + " - PC " + pcScore);

        } while (uScore < 3 && pcScore < 3);

        // Dichiarazione del vincitore
        if (uScore == 3) {
            System.out.println("\nHai vinto la partita!\n");
        } else {
            System.out.println("\nIl PC ha vinto la partita.\n");
        }
        scanner.close();
    }
}