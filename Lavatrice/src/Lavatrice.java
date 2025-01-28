public class Lavatrice {

    private boolean sportelloChiuso;
    private Stato stato;
    private boolean detersivoPresente;
    private int temperatura;

    // Costruttore
    public Lavatrice() {
        sportelloChiuso = true;
        stato = Stato.SPENTA;
        detersivoPresente = false;
        temperatura = 0;
    }

    // Getter
    public Stato getStato() {
        return stato;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public boolean isSportelloChiuso() {
        return sportelloChiuso;
    }

    public boolean isDetersivoPresente() {
        return detersivoPresente;
    }

    // Metodo per accensione
    public int accendi() {
        if (stato == Stato.SPENTA) {
            stato = Stato.STANDBY;
            return 112;
        } else if (stato == Stato.LAVAGGIO_IN_CORSO) {
            return 113;
        } else {
            return 114;
        }
    }

    // Metodo per aprire lo sportello
    public int apriSportello() {
        if (stato != Stato.LAVAGGIO_IN_CORSO) {
            sportelloChiuso = false;
            return 125;
        } else if (!sportelloChiuso) {
            return 1;
        } else
            return 3;
    }

    // Metodo per chiudere lo sportello
    public void chiudiSportello() {
        sportelloChiuso = true;
    }

    // Metodo per aggiungere il detersivo
    public void aggiungiDetersivo() {
        if (!detersivoPresente) {
            detersivoPresente = true;
        }
    }

    // Metodo per settare la temperatura
    public boolean setTemperatura(int temperatura) {
        if (stato == Stato.STANDBY && temperatura >= 0 && temperatura <= 90) {
            this.temperatura = temperatura;
            return true;
        } else
            return false;
    }

    // Metodo per avviare il lavaggio
    public void avviaLavaggio() {
        if (stato == Stato.STANDBY && sportelloChiuso && detersivoPresente) {
            stato = Stato.LAVAGGIO_IN_CORSO;
        }
    }

    // Metodo per terminare il lavaggio
    public boolean terminaLavaggio() {
        if (stato == Stato.LAVAGGIO_IN_CORSO) {
            stato = Stato.STANDBY;
            detersivoPresente = false;
            return true;
        } else
            return false;
    }


    // Metodo per spegnere la lavatrice
    public boolean spegni() {
        if (stato == Stato.STANDBY) {
            stato = Stato.SPENTA;
            return true;
        } else
            return false;
    }
}