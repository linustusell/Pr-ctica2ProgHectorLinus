package prog2.model;

public abstract class AccesAsfalt extends Acces{

    private float metresQuadrat;

    public AccesAsfalt (String nom, boolean obert, float metresQuadrat) {
        super(nom, obert);
        this.metresQuadrat = metresQuadrat;
    }

    public float getMetresQuadrat() {
        return metresQuadrat;
    }
    public void setMetresQuadrat(int metresQuadrat) {
        this.metresQuadrat = metresQuadrat;
    }

}
