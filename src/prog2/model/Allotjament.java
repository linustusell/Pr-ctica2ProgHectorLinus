package prog2.model;

import java.time.LocalDate;

public abstract class Allotjament implements InAllotjament {
    enum Iluminacio{"100%", "50%", "0%"};
    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private String estat;
    private Iluminacio iluminacio;

    public Allotjament(String nom, String id, long estadaMinimaALTA, long estadaMinimaBAIXA, String estat) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.estat = estat;
    }

    // Temporada ALTA: del 21/03 al 20/09. Temporada BAIXA: la resta.
    public static InAllotjament.Temp getTemporada(LocalDate data) {
        int mes = data.getMonthValue();
        int dia = data.getDayOfMonth();

        boolean esTemporadaAlta =
                (mes > 3 && mes < 9) ||
                        (mes == 3 && dia >= 21) ||
                        (mes == 9 && dia <= 20);
        if (esTemporadaAlta){
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEstat() { return estat; }

    public long getEstadaMinima(InAllotjament.Temp temp){
        if (temp == InAllotjament.Temp.ALTA){
            return estadaMinimaALTA;
        } else {
            return estadaMinimaBAIXA;
        }
    }

    public void setEstadaMinima(long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
    }

    public abstract boolean correcteFuncionament();

    @Override
    public String toString() {
        return "Nom=" + nom +
                ", Id=" + id +
                ", estada mínima en temp ALTA: " + estadaMinimaALTA +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA+".";
    }
}

