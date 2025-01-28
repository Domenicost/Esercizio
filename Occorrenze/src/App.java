import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Chiedi all'utente quante volte generare numeri casuali
        System.out.print("Quante volte vuoi generare numeri casuali tra 1 e 10? ");
        int nGen = scanner.nextInt();

        // Array per tenere traccia delle occorrenze dei numeri da 1 a 10
        int[] occorrenze = new int[10];

        // Genera i numeri casuali e registra le occorrenze
        for (int i = 0; i < nGen; i++) {
            int nCasuale = random.nextInt(10) + 1; // Genera un numero tra 1 e 10
            occorrenze[nCasuale - 1]++;
        }

        // Stampa i risultati
        System.out.println("Risultati:");
        for (int i = 0; i < occorrenze.length; i++) {
            System.out.println("Numero " + (i + 1) + ": " + occorrenze[i] + " occorrenze");
        }

        // Trova il numero con più e meno occorrenze
        int maxOccorrenze = occorrenze[0];
        int minOccorrenze = occorrenze[0];
        int numeroPiuFrequente = 1;
        int numeroMenoFrequente = 1;

        for (int i = 1; i < occorrenze.length; i++) {
            if (occorrenze[i] > maxOccorrenze) {
                maxOccorrenze = occorrenze[i];
                numeroPiuFrequente = i + 1;
            }
            if (occorrenze[i] < minOccorrenze) {
                minOccorrenze = occorrenze[i];
                numeroMenoFrequente = i + 1;
            }
        }

        System.out.println("\nIl numero più frequente è " + numeroPiuFrequente);
        System.out.println("Il numero meno frequente è " + numeroMenoFrequente);

        scanner.close();
    }
}