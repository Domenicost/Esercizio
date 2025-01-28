import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Creazione della SIM e dello Smartphone
        SIM sim = new SIM("1234567890", "OperatoreX", 0.10, 0.05);
        Smartphone smartphone = new Smartphone("ModelloY", "MarcaZ", sim);

        int scelta;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Visualizza contatti");
            System.out.println("3. Effettua chiamata");
            System.out.println("4. Invia SMS");
            System.out.println("5. Visualizza registro chiamate");
            System.out.println("6. Verifica credito");
            System.out.println("7. Ricarica SIM");
            System.out.println("8. Esci");
            System.out.println("9. Cambia SIM");
            System.out.print("Scegli un'opzione: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma la nuova linea

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci il numero: ");
                    String numero = scanner.nextLine();
                    smartphone.aggiungiContatto(nome, numero);
                    System.out.println("Contatto aggiunto.");
                    break;
                case 2:
                    System.out.println("\nContatti:");
                    for (Contatto contatto : smartphone.visualizzaContatti()) {
                        System.out.println(contatto.getNome() + " - " + contatto.getNumero());
                    }
                    break;
                case 3:
                    System.out.print("Inserisci il numero da chiamare: ");
                    numero = scanner.nextLine();
                    System.out.print("Inserisci la durata della chiamata (minuti): ");
                    int durata = scanner.nextInt();
                    smartphone.effettuaChiamata(numero, durata);
                    break;
                case 4:
                    System.out.print("Inserisci il numero a cui inviare l'SMS: ");
                    numero = scanner.nextLine();
                    smartphone.inviaSMS(numero);
                    break;
                case 5:
                    System.out.println("\nRegistro chiamate:");
                    for (Chiamata chiamata : smartphone.visualizzaRegistroChiamate()) {
                        System.out.println(chiamata);
                    }
                    break;
                case 6:
                    System.out.println("Credito residuo: " + sim.verificaCredito() + " €");
                    break;
                case 7:
                    System.out.print("Inserisci l'importo da ricaricare: ");
                    double importo = scanner.nextDouble();
                    sim.ricarica(importo);
                    System.out.println("Ricarica effettuata. Credito attuale: " + sim.verificaCredito() + " €");
                    break;
                case 8:
                    System.out.println("Uscita dal programma.");
                    break;
                case 9:
                    System.out.println("Inserisci il numero della nuova SIM: ");
                    String numeroNuovaSIM = scanner.nextLine();
                    System.out.println("Inserisci il nome dell'operatore: ");
                    String operatoreNuovaSIM = scanner.nextLine();
                    SIM nuovaSim = new SIM(numeroNuovaSIM, operatoreNuovaSIM, 0.15, 0.07);
                    smartphone.cambiaSIM(nuovaSim);
                    System.out.println("SIM cambiata.");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        } while (scelta != 8);

        scanner.close();
    }
}
