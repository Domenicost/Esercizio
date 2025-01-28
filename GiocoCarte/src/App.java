import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        double[] valoriCarte = { 1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5 };
        String[] nomiCarte = { "Asso", "2", "3", "4", "5", "6", "7", "8", "9", "Re" };
        String[] semiCarte = { "Denari", "Bastoni", "Coppe", "Spade" };
        double budget = 100.0;

        System.out.println("--------------------------------------");
        System.out.println("Benvenuto al gioco del 7 e mezzo!");
        System.out.println("--------------------------------------");

        boolean giocareAncora = true;

        while (giocareAncora && budget > 0) {
            System.out.print("\nQuanto vuoi puntare? (Budget disponibile: €" + budget + ") ");
            double puntata = scanner.nextDouble();
            scanner.nextLine();
            if (puntata > budget || puntata <= 0) {
                System.out.println("Puntata non valida.");
                continue;
            }

            boolean[][] carteUscite = new boolean[nomiCarte.length][semiCarte.length];

            double punteggioGiocatore = 0;
            double punteggioBanco = 0;
            boolean turnoGiocatore = true;
            boolean giocatoreSballato = false;
            boolean bancoSballato = false;

            // Variabili per la matta del giocatore
            boolean mattaPescataGiocatore = false;
            boolean primaCartaMattaGiocatore = false;
            int cartePescateGiocatore = 0;

            // Turno del giocatore
            while (turnoGiocatore) {
                int indiceCarta, indiceSeme;
                do {
                    indiceCarta = random.nextInt(nomiCarte.length);
                    indiceSeme = random.nextInt(semiCarte.length);
                } while (carteUscite[indiceCarta][indiceSeme]);

                carteUscite[indiceCarta][indiceSeme] = true;
                String cartaPescata = nomiCarte[indiceCarta];
                double valoreCarta = valoriCarte[indiceCarta];
                String semeCarta = semiCarte[indiceSeme];
                cartePescateGiocatore++;

                // Controllo se è la matta (Re di Denari)
                boolean MattaGiocatore = (indiceCarta == 9 && indiceSeme == 0);
                if (MattaGiocatore) {
                    // Matta vale inizialmente 0.5
                    valoreCarta = 0.5;
                    mattaPescataGiocatore = true;
                    if (punteggioGiocatore == 0 && cartePescateGiocatore == 1) {
                        // Se è la prima ed unica carta del giocatore
                        primaCartaMattaGiocatore = true;
                    }
                }
                punteggioGiocatore += valoreCarta;

                System.out.println("Hai pescato: " + cartaPescata + " di " + semeCarta + " (" + valoreCarta + ")");
                System.out.println("Punteggio: " + punteggioGiocatore);

                if (punteggioGiocatore > 7.5) {
                    System.out.println("\nHai sballato! Il banco vince.");
                    giocatoreSballato = true;
                    break;
                }

                System.out.print("Vuoi pescare un'altra carta? (s/n): ");
                String risposta = scanner.nextLine();
                if (risposta.equalsIgnoreCase("n")) {
                    turnoGiocatore = false;
                }
            }

            // Se il giocatore non ha sballato e ha pescato la matta, può assegnarle un
            // nuovo valore
            if (!giocatoreSballato && mattaPescataGiocatore) {
                if (!(primaCartaMattaGiocatore && cartePescateGiocatore == 1)) {
                    System.out.println("Hai pescato la matta. Attualmente vale 0.5.");
                    System.out.println("Che valore vuoi assegnare alla matta?");
                    System.out.println(
                            "Puoi inserire '0.5' oppure un intero tra 1 e 7. Se non inserisci un valore valido, la matta varrà 7.");

                    double valoreMatta = scanner.nextDouble();

                    if (valoreMatta < 7) {
                        punteggioGiocatore = punteggioGiocatore - 0.5 + valoreMatta;
                    } else
                        punteggioGiocatore += 7;

                    System.out.println("Punteggio Finale: " + punteggioGiocatore);

                    if (punteggioGiocatore > 7.5) {
                        System.out.println("Hai sballato!");
                        giocatoreSballato = true;
                    }
                }
            }

            // Variabili per la matta del banco
            boolean mattaPescataBanco = false;
            boolean primaCartaMattaBanco = false;
            int cartePescateBanco = 0;

            if (!giocatoreSballato) {
                System.out.println("Turno del banco.");

                while (punteggioBanco < 5.5) {
                    int indiceCarta, indiceSeme;
                    do {
                        indiceCarta = random.nextInt(nomiCarte.length);
                        indiceSeme = random.nextInt(semiCarte.length);
                    } while (carteUscite[indiceCarta][indiceSeme]);

                    carteUscite[indiceCarta][indiceSeme] = true;

                    String cartaPescata = nomiCarte[indiceCarta];
                    double valoreCarta = valoriCarte[indiceCarta];
                    String semeCarta = semiCarte[indiceSeme];

                    cartePescateBanco++;

                    boolean MattaBanco = (indiceCarta == 9 && indiceSeme == 0);
                    if (MattaBanco) {
                        valoreCarta = 0.5;
                        mattaPescataBanco = true;
                        if (punteggioBanco == 0 && cartePescateBanco == 1) {
                            primaCartaMattaBanco = true;
                        }
                    }
                    punteggioBanco += valoreCarta;

                    System.out
                            .println("Il banco pesca: " + cartaPescata + " di " + semeCarta + " (" + valoreCarta + ")");
                    System.out.println("Punteggio del banco: " + punteggioBanco);

                    if (punteggioBanco > 7.5) {
                        System.out.println("\nIl banco ha sballato! Tu vinci.");
                        bancoSballato = true;
                        break;
                    }
                }

                // Se il banco non ha sballato e ha pescato la matta, può assegnarle un nuovo
                // valore
                if (!bancoSballato && mattaPescataBanco) {
                    if (!(primaCartaMattaBanco && cartePescateBanco == 1)) {

                        System.out.println("Il Banco ha pescato la matta.");

                        double valoreMattaBanco;
                        double punteggioBaseBanco = punteggioBanco - 0.5;

                        if (punteggioGiocatore < 7.5) {
                            valoreMattaBanco = 7 - punteggioBaseBanco;
                            punteggioBanco = punteggioBaseBanco + valoreMattaBanco;

                        } else if (punteggioGiocatore == 7.5) {
                            if (punteggioBaseBanco == 7) {
                                valoreMattaBanco = 0.5;
                                punteggioBanco = punteggioBaseBanco + valoreMattaBanco;
                            } else {
                                valoreMattaBanco = 7 - punteggioBaseBanco;
                                punteggioBanco = punteggioBaseBanco + valoreMattaBanco;
                            }
                        } else {
                            valoreMattaBanco = 7 - punteggioBaseBanco;
                            punteggioBanco = punteggioBaseBanco + valoreMattaBanco;
                        }

                        System.out.println("Il Banco ha scelto che la sua matta vale: " + valoreMattaBanco);
                        System.out.println("Punteggio del banco: " + punteggioBanco);

                        if (punteggioBanco > 7.5) {
                            System.out.println("Il banco ha sballato!");
                            bancoSballato = true;
                        }
                    }
                }

                // Risultato finale
                if (!giocatoreSballato && !bancoSballato) {
                    System.out.println(
                            "Punteggio finale: Giocatore " + punteggioGiocatore + " - Banco " + punteggioBanco);
                    if (punteggioGiocatore > punteggioBanco) {
                        System.out.println("\nHai vinto!");
                        budget += puntata;
                    } else if (punteggioGiocatore < punteggioBanco) {
                        System.out.println("\nIl banco vince.");
                        budget -= puntata;
                    } else {
                        System.out.println("Pareggio! La puntata viene restituita.");
                    }
                } else if (giocatoreSballato) {
                    budget -= puntata;
                } else if (bancoSballato) {
                    budget += puntata;
                }

                if (budget <= 0) {
                    System.out.println("Hai esaurito il tuo budget. Grazie per aver giocato!");
                    break;
                }

                System.out.println("Vuoi giocare un'altra partita? (s/n)");
                String risposta = scanner.nextLine();
                if (risposta.equalsIgnoreCase("n")) {
                    giocareAncora = false;
                }
            }

            System.out.println("Grazie per aver giocato! Esci con: €" + budget);
            scanner.close();
        }
    }

}