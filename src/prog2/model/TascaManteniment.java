package prog2.model;

public class TascaManteniment implements InTascaManteniment{
    //enum dels tipus de tasca manteniment
    public static enum TipusTascaManteniment{
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    }

    private int num;
    private TipusTascaManteniment tipus;
    private Allotjament allotjament;
    private String data;
    private int dies;

    //Constructor TascaManteniment
    public TascaManteniment(int num, TipusTascaManteniment tipus,
                            Allotjament allotjament, String data, int dies){

        this.num = num;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;

    }

    public  int getNum() {

        return num;
    }

    public TascaManteniment.TipusTascaManteniment getTipus() {

        return tipus;
    }

    public Allotjament getAllotjament(){

        return allotjament;
    }

    public String getData(){

        return data;
    }

    public int getDies(){

        return dies;
    }

    public void setNum(int num){

        this.num = num;
    }

    public void setTipus(TipusTascaManteniment tipus){

        this.tipus = tipus;
    }

    @Override
    public void setAllotjament(Allotjament allotjament) {

        this.allotjament = allotjament;
    }

    @Override
    public void setData(String data) {

        this.data = data;
    }

    @Override
    public void setDies(int dies) {

        this.dies = dies;
    }

    @Override
    public String getIluminacioAllotjament() {
        switch (tipus)
            {
            case Reparacio, RevisioTecnica: return "50%";
            case Desinfeccio: return "0%";
            case Neteja: return "100%";
            default: return null;
            }

    }

    @Override
    public String toString() {
        return "Tasca " + num + " - " + tipus + " - " + allotjament.getNom() + " - " + data + " - " + dies + " dies";
    }
}
