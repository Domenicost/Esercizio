import java.util.HashMap;
import java.util.Map;

class Pikachu extends Pokemon implements IEvolvibile, IAttaccoSpeciale {
    public Pikachu() {
        super("Pikachu", "Elettrico", 100, 50, 10);
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
                case "Pikatchu":
                    nome = "Raichu";
                    puntiAttacco += 30;
                    puntiDifesa += 20;
                    puntiSalute += 20;
                    System.out.println("Pikachu si è evoluto in Raichu!");
                    System.out.println(nome + " ha " + puntiSalute + " punti salute, " + puntiAttacco + " punti attacco e " + puntiDifesa + " punti difesa");
                    break;
                case "Raichu":
                    System.out.println("Raichu non può evolversi più di così");
                    break;
            }
        } else {
            System.out.println(nome + " non può evolversi al momento");
        }
    }

    @Override
    public void eseguiMossaSpeciale(Pokemon avversario) {
        int danno = puntiAttacco + 20 + modificatoreDanno(avversario.tipo);
        System.out.println(nome + " ha usato la mossa speciale e ha inflitto " + (danno-puntiDifesa) + " danni a " + avversario.nome);
        avversario.subisciDanno(danno);
    }

    @Override
    public Map<Integer, String> opzioni() {
        
        Map<Integer, String> opzioni = new HashMap<>();
        opzioni.put(1, "1. Attacca");
        opzioni.put(2, "2. Mossa Speciale");
        if (vittorie >= 1) {
            opzioni.put(5, "3. Evolvi");
        }
        return opzioni;
    }

    @Override
    public String toString() {
        return "Pikachu";
    }

}