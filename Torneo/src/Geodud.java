import java.util.HashMap;
import java.util.Map;

class Geodud extends Pokemon implements ICorazzato, IEvolvibile, IAttaccoSpeciale {
    public Geodud() {
        super("Geodud", "Roccia", 100, 50, 10);
    }

    @Override
    public void attacca(Pokemon avversario) {
        int danno = puntiAttacco + modificatoreDanno(avversario.tipo);
        avversario.subisciDanno(danno);
        System.out.println(nome + " ha inflitto " + danno + " danni a " + avversario.nome);
    }

    @Override
    public void attivaCorazza() {
        corazzato = true;
        puntiDifesa += 30;
        puntiAttacco -= 15;
        System.out.println(nome + " ha attivato la corazza! Ora subisce 10 danni in meno!");
    }

    @Override
    public void evolvi() {
        if (vittorie >= 1) {
            switch (nome) {
                case "Geodud":
                    nome = "Graveler";
                    puntiAttacco += 10;
                    puntiDifesa += 5;
                    puntiSalute += 5;
                    System.out.println("Geodud si è evoluto in Graveler!");
                    break;
                case "Graveler":
                    nome = "Golem";
                    puntiAttacco += 30;
                    puntiDifesa += 20;
                    puntiSalute += 20;
                    System.out.println("Graveler si è evoluto in Golem!");
                    break;
                case "Golem":
                    System.out.println("Golem non può evolversi più di così");
                    break;
            }
        } else {
            System.out.println(nome + " non può evolversi al momento");
        }
    }

    @Override
    public void eseguiMossaSpeciale(Pokemon avversario) {
        int danno = puntiAttacco + 20 + modificatoreDanno(avversario.tipo);
        avversario.subisciDanno(danno);
        System.out.println(nome + " ha usato la mossa speciale e ha inflitto " + danno + " danni a " + avversario.nome);
    }

    @Override
    public Map<Integer, String> opzioni() {
        Map<Integer, String> opzioni = new HashMap<>();
        opzioni.put(1, "1. Attacca");
        opzioni.put(2, "2. Mossa Speciale");
        opzioni.put(4, "3. Attiva Corazza");
        if (vittorie >= 1) {
            opzioni.put(5, "4.Evolvi");
        }
        return opzioni;
    }

    @Override
    public String toString() {
        return "Geodud";
    }

}
