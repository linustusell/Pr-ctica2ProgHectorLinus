package prog2.model;

public class CarreteraTerra extends AccesTerra {

    private float amplada;

    public CarreteraTerra(String nom, boolean obert, float metres, float amplada) {
        super(nom, obert, metres);
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public float getAmplada() {
        return amplada;
    }

    public void setAmplada(int amplada) {
        this.amplada = amplada;
    }

    public String toString() {
        return super.toString() + " amplada carretera " + amplada + "m. ";
    }
}
