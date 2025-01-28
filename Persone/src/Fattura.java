import java.time.LocalDate;

public class Fattura {
    private int nr;
    private LocalDate data;
    private String cliente;
    private double importo;

    public Fattura(int nr, LocalDate data, String cliente, double importo) {
        this.nr = nr;
        this.data = data;
        this.cliente = cliente;
        this.importo = importo;
    }

    public int getNr() {
        return nr;
    }

    public LocalDate getData() {
        return data;
    }

    public String getCliente() {
        return cliente;
    }

    public double getImporto() {
        return importo;
    }

    @Override
    public String toString() {
        return "Fattura{" +
                "nr=" + nr +
                ", data=" + data +
                ", cliente='" + cliente + '\'' +
                ", importo=" + importo +
                '}';
    }
}
