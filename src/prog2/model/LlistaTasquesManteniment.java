package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment{
    private ArrayList<TascaManteniment> llistaTasquesManteniment;

    public LlistaTasquesManteniment(){
        llistaTasquesManteniment = new ArrayList<>();
    }

    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping{
        // 1. Convertir String a enum
        TascaManteniment.TipusTascaManteniment tipusEnum;
        try {
            tipusEnum = TascaManteniment.TipusTascaManteniment.valueOf(tipus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("El tipus de tasca no existeix");
        }

        // 2. Comprovar si ja té una tasca
        for (TascaManteniment t : llistaTasquesManteniment) {
            if (t.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Aquest allotjament ja té una tasca");
            }
        }

        // 3. Crear tasca i afegir-la
        TascaManteniment tasca = new TascaManteniment(num, tipusEnum, allotjament, data, dies);
        llistaTasquesManteniment.add(tasca);

        // 4. Tancar allotjament
        allotjament.tancarAllotjament(tasca);
    }
}
