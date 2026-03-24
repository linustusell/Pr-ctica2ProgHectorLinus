package prog2.model;

/**
 * Superclasse de Bungalow, Glamping i MobilHome.
 */
public abstract class Casa extends Allotjament {

    private String mida;
    private int habitacions;
    private int placesPersones;


    public Casa(String nom_, String idAllotjament_,
                long estadaMinimaALTA, long estadaMinimaBAIXA, String estat,
                String mida, int habitacions, int placesPersones) {
        super(nom_, idAllotjament_, estadaMinimaALTA, estadaMinimaBAIXA, estat);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;

    }

    public String getMida() { return mida; }
    public void setMida(String mida) { this.mida = mida; }

    public int getHabitacions() { return habitacions; }
    public void setHabitacions(int habitacions) { this.habitacions = habitacions; }

    public int getPlacesPersones() { return placesPersones; }
    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones; }

    @Override
    public abstract boolean correcteFuncionament();

    @Override
    public String toString() {
        return super.toString() +
                ", Casa{mida=" + mida +
                ", habitacions=" + habitacions +
                ", placesPersones=" + placesPersones + "}";
    }
}
