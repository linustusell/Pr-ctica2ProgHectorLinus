package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {

    private int pesMaxim;

    public CarreteraAsfalt(String nom, boolean obert, int metresQuadrats, int pesMaxim) {
        super(nom, obert, metresQuadrats);
        this.pesMaxim = pesMaxim;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public int getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(int pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    public String toString() {
        return super.toString() + ", pes maxim: " + pesMaxim + "kg. ";
    }
}
