package prog2.model;

public abstract class Acces implements InAcces{

    private String nom;
    private boolean obert;
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nom, boolean obert) {
        this.nom = nom;
        this.obert = obert;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        llistaAllotjaments.afegirAllotjament(allotjament);
    }

    @Override
    public void tancarAcces() {
        obert = false;
    }
    @Override
    public void obrirAcces() {
        obert = true;
    }

    @Override
    public abstract boolean isAccessibilitat();

    public String getNom() {
        return nom;
    }

    public boolean getEstat(){
        return obert;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return llistaAllotjaments;
    }
}
