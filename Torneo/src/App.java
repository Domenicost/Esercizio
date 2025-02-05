import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();

        // Creazione dei Pokémon
        Pikachu pikachu = new Pikachu();
        Charmander charmander = new Charmander();
        Venusaur venusaur = new Venusaur();
        Geodud geodud = new Geodud();

        ArrayList<Pokemon> listaPokemon = new ArrayList<>();
        listaPokemon.add(pikachu);
        listaPokemon.add(charmander);
        listaPokemon.add(venusaur);
        listaPokemon.add(geodud);

        // Creazione Allenatore 1 (pesca 2 Pokemon casuali)
        ArrayList<Pokemon> squadraAllenatore1 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(listaPokemon.size());
            squadraAllenatore1.add(listaPokemon.remove(index));
        }
        Allenatore a1 = new Allenatore("Ash", squadraAllenatore1);

        // Creazione Allenatore 2 (Pokemon rimanenti)
        ArrayList<Pokemon> squadraAllenatore2 = new ArrayList<>();
        squadraAllenatore2.addAll(listaPokemon);
        Allenatore a2 = new Allenatore("Brock", squadraAllenatore2);


        // Inizia Battaglia
        System.out.println("--------------------------------");
        System.out.println("INIZIO BATTAGLIA!");
        System.out.println("--------------------------------");


        // Seleziona (Random) Allenatore e Pokemon Iniziale
        int sceltaAllenatore = random.nextInt(2);
        Allenatore allenatoreIniziale = sceltaAllenatore == 0 ? a1 : a2;
        System.out.println("Inizia " + allenatoreIniziale.getNome());
        System.out.println("Squadra: " + allenatoreIniziale.getSquadra());

        Pokemon pokemonInCampo = allenatoreIniziale.getSquadra()
                .get(random.nextInt(allenatoreIniziale.getSquadra().size()));
        System.out.println("Sceglie " + pokemonInCampo.getNome() + "!!!!!");
        System.out.println();

        // Avversario
        Allenatore allenatoreAvversario = allenatoreIniziale == a1 ? a2 : a1;
        System.out.println("Avversario: " + allenatoreAvversario.getNome());
        System.out.println("Squadra: " + allenatoreAvversario.getSquadra());

        Pokemon pokemonAvversario = allenatoreAvversario.getSquadra()
                .get(random.nextInt(allenatoreAvversario.getSquadra().size()));
        System.out.println("Sceglie " + pokemonAvversario.getNome() + "!!!!!\n");

        boolean battagliaFinita = false;
        int turno = 1;

        // Ciclo di turni
        while (!battagliaFinita) {

            System.out.println("***********************");
            System.out.println("Turno " + turno);
            System.out.println("***********************\n");

            // Turno allenatore iniziale
            System.out.println("Tocca a " + pokemonInCampo.getNome());
            pokemonInCampo.getOpzioni();
            int sceltaCasuale = pokemonInCampo.scegliOpzione();
            System.out.println("\n" + pokemonInCampo.getNome() + " sceglie: " + pokemonInCampo.opzioni().get(sceltaCasuale));

            switch (sceltaCasuale) {
                case 1:
                    pokemonInCampo.attacca(pokemonAvversario);
                    break;
                case 2:
                    if (pokemonInCampo instanceof IAttaccoSpeciale) {
                        ((IAttaccoSpeciale) pokemonInCampo).eseguiMossaSpeciale(pokemonAvversario);
                    } else {
                        System.out.println(pokemonInCampo.getNome() + " non può eseguire una mossa speciale.");
                    }
                    break;
                case 3:
                    if (pokemonInCampo instanceof IVolante) {
                        ((IVolante) pokemonInCampo).vola();
                    } else {
                        System.out.println(pokemonInCampo.getNome() + " non può volare.");
                    }
                    break;
                case 4:
                    if (pokemonInCampo instanceof ICorazzato) {
                        ((ICorazzato) pokemonInCampo).attivaCorazza();
                    } else {
                        System.out.println(pokemonInCampo.getNome() + " non può attivare la corazza.");
                    }
                    break;
                case 5:
                    if (pokemonInCampo instanceof IEvolvibile) {
                        ((IEvolvibile) pokemonInCampo).evolvi();
                    } else {
                        System.out.println(pokemonInCampo.getNome() + " non può evolversi.");
                    }
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }

            // Verifica se allenatore Avversario ha tutti i Pokemon KO
            boolean allenatoreAvversarioSconfitto = allenatoreAvversario.getSquadra().stream()
                    .allMatch(p -> p.getPuntiSalute() <= 0);

            // Se il Pokemon Avversario è KO, seleziona un nuovo Pokemon
            if (pokemonAvversario.getPuntiSalute() == 0 && !allenatoreAvversarioSconfitto) {
                System.out.println(pokemonAvversario.getNome() + " è KO! Scelgo un nuovo Pokémon!");
                Pokemon nuovoPokemon = allenatoreAvversario.getSquadra().stream().filter(p -> p.getPuntiSalute() > 0)
                        .findFirst().get();
                System.out.println(allenatoreAvversario.getNome() + " sceglie " + nuovoPokemon.getNome() + "!");
                pokemonAvversario = nuovoPokemon;
                pokemonInCampo.incrementaVittorie();
            }

            // Turno Avversario
            System.out.println("\nOra tocca a " + pokemonAvversario.getNome());
            pokemonAvversario.getOpzioni();
            sceltaCasuale = pokemonAvversario.scegliOpzione();
            System.out.println("\n" + allenatoreAvversario.getNome() + " sceglie: " + pokemonAvversario.opzioni().get(sceltaCasuale));

            switch (sceltaCasuale) {
                case 1:
                pokemonAvversario.attacca(pokemonInCampo);
                    break;
                case 2:
                    if (pokemonAvversario instanceof IAttaccoSpeciale) {
                        ((IAttaccoSpeciale) pokemonAvversario).eseguiMossaSpeciale(pokemonInCampo);
                    } else {
                        System.out.println(pokemonAvversario.getNome() + " non può eseguire una mossa speciale.");
                    }
                    break;
                case 3:
                    if (pokemonAvversario instanceof IVolante) {
                        ((IVolante) pokemonAvversario).vola();
                    } else {
                        System.out.println(pokemonAvversario.getNome() + " non può volare.");
                    }
                    break;
                case 4:
                    if (pokemonAvversario instanceof ICorazzato) {
                        ((ICorazzato) pokemonAvversario).attivaCorazza();
                    } else {
                        System.out.println(pokemonAvversario.getNome() + " non può attivare la corazza.");
                    }
                    break;
                case 5:
                    if (pokemonAvversario instanceof IEvolvibile) {
                        ((IEvolvibile) pokemonAvversario).evolvi();
                    } else {
                        System.out.println(pokemonAvversario.getNome() + " non può evolversi.");
                    }
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }

            // Verifica se allenatore Iniziale ha tutti i Pokemon KO
            boolean allenatoreInizialeSconfitto = allenatoreIniziale.getSquadra().stream()
                    .allMatch(p -> p.getPuntiSalute() <= 0);

            // Se il Pokemon attuale è KO, seleziona un nuovo Pokemon
            if (pokemonInCampo.getPuntiSalute() == 0 && !allenatoreInizialeSconfitto) {
                System.out.println(pokemonInCampo.getNome() + " è KO! Scelgo un nuovo Pokémon!");

                Pokemon nuovoPokemon = allenatoreIniziale.getSquadra().stream().filter(p -> p.getPuntiSalute() > 0)
                        .findFirst().get();
                System.out.println(allenatoreIniziale.getNome() + " sceglie " + nuovoPokemon.getNome() + "!");
                pokemonInCampo = nuovoPokemon;
                pokemonAvversario.incrementaVittorie();
            }


            // Visualizza statistiche dopo il turno
            System.out.println("\n--------------------------------");
            System.out.println("Statistiche Turno " + turno + "\n");
            pokemonInCampo.visualizzaStato();
            pokemonAvversario.visualizzaStato();
            turno++;

            // Stampa Vincitore
            if (allenatoreInizialeSconfitto || allenatoreAvversarioSconfitto) {
                Allenatore vincitore = allenatoreInizialeSconfitto ? allenatoreAvversario : allenatoreIniziale;
                System.out.println("--------------------------------");
                System.out.println("BATTAGLIA FINITA!");
                System.out.println("--------------------------------");
                System.out.println("\nVince: " + vincitore.getNome() + "!\n");
                vincitore.StatoSquadra();
                battagliaFinita = true;
            }
        }

    }

}
