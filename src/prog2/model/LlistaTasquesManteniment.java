package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment{
    private ArrayList<TascaManteniment> llistaTasquesManteniment;

    public LlistaTasquesManteniment(){
        llistaTasquesManteniment = new ArrayList<>();
    }

    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping{
        TascaManteniment.TipusTascaManteniment tipusEnum;
        try {
            tipusEnum = TascaManteniment.TipusTascaManteniment.valueOf(tipus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("El tipus de tasca no existeix");
        }

        Iterator<TascaManteniment> itr = llistaTasquesManteniment.iterator();
        while (itr.hasNext()) {
            TascaManteniment t = itr.next();
            if (t.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Aquest allotjament ja té una tasca");
            }
        }

        TascaManteniment tasca = new TascaManteniment(num, tipusEnum, allotjament, data, dies);
        llistaTasquesManteniment.add(tasca);

        allotjament.tancarAllotjament(tasca);
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        boolean esta = false;
        Iterator<TascaManteniment> itr = llistaTasquesManteniment.iterator();
        while (itr.hasNext()) {
            TascaManteniment t = itr.next();
            if (tasca.equals(t)) {
                Allotjament allotjament = t.getAllotjament();
                allotjament.tancarAllotjament(tasca);
                llistaTasquesManteniment.remove(tasca);
                esta = true;
            }
        }
        if (!esta)
            throw new ExcepcioCamping("La tasca no existeix. ");

    }

    public String llistarTasquesManteniment() throws ExcepcioCamping{
        String llista = "";

        if(llistaTasquesManteniment.isEmpty())
            throw new ExcepcioCamping("La llista de tasques de manteniment està buida.");

        Iterator<TascaManteniment> itr = llistaTasquesManteniment.iterator();
        while(itr.hasNext()){
            TascaManteniment t = itr.next();
            llista += t.toString();
        }
        return llista;
    }

    public TascaManteniment  getTascaManteniment(int num) throws ExcepcioCamping{
        Iterator<TascaManteniment> itr = llistaTasquesManteniment.iterator();

        while(itr.hasNext()){
            TascaManteniment t = itr.next();
            if(t.getNum() == num)
                return t;
        }

        throw new ExcepcioCamping("La tasques de manteniment no existeix");
    }
}
