package prog2.model;

/**
 * Funciona correctament si té terrassa amb barbacoa.
 */
public class MobilHome extends Casa {

    private static final long ESTADA_MIN_ALTA  = 5;
    private static final long ESTADA_MIN_BAIXA = 3;

    private boolean terrassaBarbacoa;

    public MobilHome(String nom, String id, boolean estat, String iluminacio,
                     float mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa) {
        super(nom, id, estat, iluminacio,ESTADA_MIN_ALTA, ESTADA_MIN_BAIXA, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa; }
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa; }

    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", MobilHome{terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }
}