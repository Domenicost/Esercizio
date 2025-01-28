import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        MacchinaCaffe macchina = new MacchinaCaffe();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        System.out.println("---------------------------------");
        System.out.println("MACCHINA DEL CAFFE'");
        System.out.println("---------------------------------");

        while (continua) {
            System.out.println("\nSeleziona un'opzione:\n");
            System.out.println("1. Mostra menu");
            System.out.println("2. Inserisci monete");
            System.out.println("3. Seleziona caffè");
            System.out.println("4. Carica caffè");
            System.out.println("5. Esci");
            System.out.print("\nScelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    macchina.mostraMenu();
                    break;
                case 2:
                    System.out.println(
                            "\nInserisci monete (tagli accettati: 0.5€, 1.0€, 2.0€) [Inserisci 0 per terminare!]\n");
                    macchina.inserisciMoneta();
                    break;
                case 3:
                    if (macchina.getCredito() == 0) {
                        System.out.println("\nErrore! Per entrare in questo menu devi inserire almeno una moneta. (Opzione 2)");
                        break;
                    } else {
                        macchina.mostraMenu();
                        System.out.print("\nCredito: " + macchina.getCredito() + "€. Inserisci Codice: ");
                        int tipo = scanner.nextInt();
                        macchina.selezionaCaffe(tipo);
                        break;
                    }
                case 4:
                    macchina.mostraMenu();
                    System.out.print("\nInserisci il tipo da caricare: ");
                    int tipoCarica = scanner.nextInt();
                    System.out.print("Inserisci la quantità da aggiungere: ");
                    int quantita = scanner.nextInt();
                    macchina.caricaCaffe(tipoCarica, quantita);
                    break;
                case 5:
                    System.out.println("Grazie per aver usato la macchina del caffè. Arrivederci!");
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }
}
