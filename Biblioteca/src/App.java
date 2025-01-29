import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        new Biblioteca(1, "Via Roma", "10", "00100", "Roma");
        new Biblioteca(2, "Via Milano", "5", "20100", "Milano");

        while (true) {
            System.out.println("\nMenu Biblioteca:");
            System.out.println("1. Aggiungi Libro");
            System.out.println("2. Aggiungi Rivista");
            System.out.println("3. Verifica Disponibilità");
            System.out.println("4. Effettua Prestito");
            System.out.println("5. Restituisci Prestito");
            System.out.println("6. Trova Collocazione Materiale");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Titolo: ");
                    String titoloLibro = scanner.nextLine();
                    System.out.print("Autore: ");
                    String autore = scanner.nextLine();
                    System.out.print("Genere: ");
                    String genereLibro = scanner.nextLine();
                    System.out.print("Editore: ");
                    String editoreLibro = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Numero Pagine: ");
                    int numeroPagine = scanner.nextInt();
                    System.out.print("ID Biblioteca: ");
                    int idBibliotecaLibro = scanner.nextInt();
                    scanner.nextLine();
                    Biblioteca.aggiungiMateriale(new Libro(titoloLibro, autore, genereLibro, editoreLibro, isbn,
                            numeroPagine, idBibliotecaLibro));
                    break;
                case 2:
                    System.out.print("Titolo: ");
                    String titoloRivista = scanner.nextLine();
                    System.out.print("Editore: ");
                    String editoreRivista = scanner.nextLine();
                    System.out.print("Genere: ");
                    String genereRivista = scanner.nextLine();
                    System.out.print("Anno: ");
                    int anno = scanner.nextInt();
                    System.out.print("Numero Volume: ");
                    int numeroVolume = scanner.nextInt();
                    System.out.print("ID Biblioteca: ");
                    int idBibliotecaRivista = scanner.nextInt();
                    scanner.nextLine();
                    Biblioteca.aggiungiMateriale(new Rivista(titoloRivista, editoreRivista, genereRivista, anno,
                            numeroVolume, idBibliotecaRivista));
                    break;
                case 3:
                    System.out.print("Inserisci codice materiale: ");
                    String codiceVerifica = scanner.nextLine();
                    boolean stato = Biblioteca.verificaDisponibilita(codiceVerifica);
                    if (stato) {
                        System.out.println("Materiale Disponibile");
                    } else
                        System.out.println("Materiale non disponibile");

                    break;
                case 4:
                    System.out.print("Inserisci codice materiale: ");
                    String codicePrestito = scanner.nextLine();
                    Biblioteca.effettuaPrestito(codicePrestito);
                    break;
                case 5:
                    System.out.print("Inserisci codice materiale: ");
                    String codiceRestituzione = scanner.nextLine();
                    Biblioteca.restituisciPrestito(codiceRestituzione);
                    break;
                case 6:
                    System.out.print("Inserisci codice materiale: ");
                    String codiceCollocazione = scanner.nextLine();
                    Biblioteca collocazione = Biblioteca.trovaCollocazione(codiceCollocazione);
                    if (collocazione != null) {
                        System.out.println("Materiale collocato presso la " + collocazione.toString());
                    } else {
                        System.out.println("Materiale non trovato.");
                    }
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}