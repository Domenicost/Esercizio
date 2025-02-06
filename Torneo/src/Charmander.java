import java.util.HashMap;
import java.util.Map;

public class Charmander extends Pokemon implements IEvolvibile, IAttaccoSpeciale, IVolante {

    public Charmander() {
        super("Charmander", "Fuoco", 100, 50, 10);
    }

    @Override
    public void attacca(Pokemon avversario) {
        int danno = puntiAttacco + modificatoreDanno(avversario.tipo);
        System.out.println(nome + " ha inflitto " + (danno-puntiDifesa) + " danni a " + avversario.nome);

        avversario.subisciDanno(danno);
    }

    @Override
    public void evolvi() {

        if (vittorie >= 1) {
            switch (nome) {
                case "Charmander":
                    nome = "Charmilion";
                    puntiAttacco += 10;
                    puntiDifesa += 5;
                    puntiSalute += 5;
                    System.out.println("Charmander si è evoluto in Charmilion!");
                    System.out.println(nome + " ha " + puntiSalute + " punti salute, " + puntiAttacco
                            + " punti attacco e " + puntiDifesa + " punti difesa");
                    break;
                case "Charmilion":
                    nome = "Charizard";
                    puntiAttacco += 30;
                    puntiDifesa += 20;
                    puntiSalute += 20;
                    System.out.println("Charmilion si è evoluto in Charizard!");
                    System.out.println(nome + " ha " + puntiSalute + " punti salute, " + puntiAttacco
                            + " punti attacco e " + puntiDifesa + " punti difesa");
                    break;
                case "Charizard":
                    System.out.println("Charizard non può evolversi più di così");
                    break;
            }
        } else
            System.out.println(nome + " non può ancora evolversi");
    }

    @Override
    public void eseguiMossaSpeciale(Pokemon avversario) {
        int danno = puntiAttacco + 20 + modificatoreDanno(avversario.tipo);
        System.out.println(nome + " ha usato la mossa speciale e ha inflitto " + (danno-puntiDifesa) + " danni a " + avversario.nome);
        avversario.subisciDanno(danno);
    }

    @Override
    public void vola() {
        volante = true;
        System.out.println(nome + " Sta volando! Ora è immune ai danni!");
    }

    @Override
    public Map<Integer, String> opzioni() {

        Map<Integer, String> opzioni = new HashMap<>();
        opzioni.put(1, "1. Attacca");
        opzioni.put(2, "2. Mossa Speciale");
        opzioni.put(3, "3. Vola");

        if (vittorie >= 1) {
            opzioni.put(5, "4. Evolvi");
        }
        return opzioni;
    }

    @Override
    public String toString() {
        return "Charmander";
    }

}