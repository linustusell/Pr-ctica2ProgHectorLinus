package prog2.model;

/**
 * Funciona correctament si té aire fred.
 */
public class Bungalow extends Casa {

    private static final long ESTADA_MIN_ALTA  = 7;
    private static final long ESTADA_MIN_BAIXA = 4;

    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;


    public Bungalow(String nom, String id,
                    String mida, boolean estat, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, id, ESTADA_MIN_ALTA, ESTADA_MIN_BAIXA, estat,
                mida, habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    public int getPlacesParquing() {
        return placesParquing; }

    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }

    public boolean isTerrassa() {
        return terrassa;
    }
    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    public boolean isTv() { return tv; }
    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isAireFred() {
        return aireFred;
    }
    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Bungalow{placesParquing=" + placesParquing +
                ", terrassa=" + terrassa +
                ", tv=" + tv +
                ", aireFred=" + aireFred + "}";
    }
}