public class SIM {
    
    private String numero;
    private String operatore;
    private double credito;
    private double costoPerMinuto;
    private double costoSMS;

    // Costruttore
    public SIM(String numero, String operatore, double costoPerMinuto, double costoSMS) {
        this.numero = numero;
        this.operatore = operatore;
        credito = 0;
        this.costoPerMinuto = costoPerMinuto;
        this.costoSMS = costoSMS;
    }

    // Metodo per verificare il credito
    public double verificaCredito() {
        return credito;
    }

    // Metodo per ricaricare il credito
    public void ricarica(double importo) {
        if (importo > 0) {
            credito += importo;
        }
    }

    // Metodo per scalare il credito
    public boolean scalaCredito(double costo) {
        if (credito >= costo) {
            credito -= costo;
            return true;
        } else {
            return false;
        }
    }

    // Getter
    public double getCostoPerMinuto() {
        return costoPerMinuto;
    }

    public double getCostoSMS() {
        return costoSMS;
    }
}
