import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Messaggio messaggio = new Messaggio();
        Scanner sc = new Scanner(System.in);

        // Seleziona lingua
        System.out.println("\nImposta Lingua:");
        System.out.println("1. Italiano");
        System.out.println("2. Inglese");

        System.out.print("\nScegli: ");
        int sceltaLingua = sc.nextInt();
        Messaggio.Lingua linguaSelezionata;

        switch (sceltaLingua) {
            case 1:
                linguaSelezionata = Messaggio.Lingua.ITALIANO;
                break;
            case 2:
                linguaSelezionata = Messaggio.Lingua.INGLESE;
                break;
            default:
                System.out.println("Scelta non valida. Impostazione di default: Italiano.");
                linguaSelezionata = Messaggio.Lingua.ITALIANO;
        }

        Lavatrice lavatrice = new Lavatrice();
        int scelta;

        do {
            System.out.println("\nMENU");
            System.out.println(messaggio.getMessaggio(1, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(2, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(3, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(4, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(5, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(6, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(7, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(8, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(9, linguaSelezionata));
            System.out.println(messaggio.getMessaggio(10, linguaSelezionata) + "\n");

            System.out.print(messaggio.getMessaggio(11, linguaSelezionata));
            scelta = sc.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println(messaggio.getMessaggio(lavatrice.accendi(), linguaSelezionata));
                    break;

                case 2:
                System.out.println(messaggio.getMessaggio(lavatrice.accendi(), linguaSelezionata));

                    if (lavatrice.isSportelloChiuso()) {
                        lavatrice.apriSportello();
                        System.out.println("\nLo sportello é aperto");
                    } else if (lavatrice.getStato() == Stato.LAVAGGIO_IN_CORSO) {
                        System.out.println("Impossibile aprire lo sportello mentre la lavatrice é in funzione");
                    } else {
                        System.out.println("Lo sportello é già aperto");
                    }
                    break;

                case 3:
                    if (!lavatrice.isSportelloChiuso()) {
                        lavatrice.chiudiSportello();
                        System.out.println("\nLo sportello é chiuso");
                    } else {
                        System.out.println("Lo sportello é già chiuso");
                    }
                    break;

                case 4:
                    if (!lavatrice.isDetersivoPresente()) {
                        lavatrice.aggiungiDetersivo();
                        System.out.println("\nIl detersivo é stato aggiunto");
                    } else {
                        System.out.println("Il detersivo é già presente");
                    }
                    break;

                case 5:

                    int temperatura = -1;
                    System.out.print("\nImposta una temperatura: ");

                    while (temperatura < 0 || temperatura > 90) {
                        temperatura = sc.nextInt();
                        if (lavatrice.setTemperatura(temperatura)) {
                            System.out.println("\nLa temperatura é: " + lavatrice.getTemperatura());
                        } else {
                            System.out.print("Temperatura non valida. Riprova: ");
                        }
                    }
                    break;

                case 6:
                    if (lavatrice.getStato() == Stato.STANDBY) {
                        if (lavatrice.isSportelloChiuso()) {
                            if (lavatrice.isDetersivoPresente()) {
                                lavatrice.avviaLavaggio();
                                System.out.println("\nIl lavaggio é stato avviato");
                            } else {
                                System.out.println("Detersivo non presente");
                            }

                        } else {
                            System.out.println("Lo sportello non é chiuso");
                        }
                    } else if (lavatrice.getStato() == Stato.LAVAGGIO_IN_CORSO) {
                        System.out.println("Lavaggio già in corso");
                    } else {
                        System.err.println("La lavatrice è spenta");
                    }
                    break;

                case 7:
                    if (lavatrice.terminaLavaggio()) {
                        System.out.println("\nIl lavaggio é terminato");
                    } else {
                        System.out.println("Nessun lavaggio da terminare");
                    }
                    break;

                case 8:
                    lavatrice.spegni();
                    System.out.println("\nLa lavatrice é spenta");
                    break;

                case 9:
                    System.out.println("\nLa lavatrice é in stato: " + lavatrice.getStato());
                    break;
            }

        } while (scelta != 10);

        sc.close();
        System.out.println("\nProgramma Terminato!");
    }
}