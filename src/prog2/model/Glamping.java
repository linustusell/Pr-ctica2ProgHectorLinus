package prog2.model;

/**
 * Funciona correctament si té casa per a mascotes.
 */
public class Glamping extends Casa {

    private static final long ESTADA_MIN_ALTA  = 3;
    private static final long ESTADA_MIN_BAIXA = 3;

    private String material;
    private boolean casaMascota;

    public Glamping(String nom, String id,
                    String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota) {
        super(nom, id, ESTADA_MIN_ALTA, ESTADA_MIN_BAIXA,
                mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isCasaMascota() {
        return casaMascota;
    }
    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Glamping{material=" + material +
                ", casaMascota=" + casaMascota + "}";
    }
}
