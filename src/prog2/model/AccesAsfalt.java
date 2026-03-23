package prog2.model;

public abstract class AccesAsfalt extends Acces{

    private int metresQuadrat;

    public AccesAsfalt (String nom, boolean obert, int metresQuadrat) {
        super(nom, obert);
        this.metresQuadrat = metresQuadrat;
    }

    public int getMetresQuadrat() {
        return metresQuadrat;
    }
    public void setMetresQuadrat(int metresQuadrat) {
        this.metresQuadrat = metresQuadrat;
    }

}
