package prog2.model;

public class CarreteraTerra extends AccesTerra {

    private int amplada;

    public CarreteraTerra(String nom, boolean obert, int metres, int amplada) {
        super(nom, obert, metres);
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public int getAmplada() {
        return amplada;
    }

    public void setAmplada(int amplada) {
        this.amplada = amplada;
    }

    public String toString() {
        return super.toString() + " amplada carretera " + amplada + "m. ";
    }
}
