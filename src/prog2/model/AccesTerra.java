package prog2.model;

public abstract class AccesTerra extends Acces {

    private int metres;

    public AccesTerra(String nom, boolean obert, int metres) {
        super(nom, obert);
        this.metres = metres;
    }

    public int getMetresQuadrat() {
        return metres;
    }

    public void setMetresQuadrat(int metresQuadrat) {
        this.metres = metresQuadrat;
    }

}
