package prog2.model;

public abstract class AccesTerra extends Acces {

    private float metres;

    public AccesTerra(String nom, boolean obert, float metres) {
        super(nom, obert);
        this.metres = metres;
    }

    public float getMetresQuadrat() {
        return metres;
    }

    public void setMetresQuadrat(int metresQuadrat) {
        this.metres = metresQuadrat;
    }

}
