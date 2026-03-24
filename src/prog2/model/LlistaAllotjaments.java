package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments implements InLlistaAllotjaments{
    private ArrayList<Allotjament> allotjaments;

    public LlistaAllotjaments(){
        allotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        allotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        Iterator<Allotjament> itrAllotjaments = allotjaments.iterator();
        while(itrAllotjaments.hasNext()){
            itrAllotjaments.next();
            itrAllotjaments.remove();
        }
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping{
        String llista = ""; int n = 0;

        Iterator<Allotjament> itrAllotjament = allotjaments.iterator();
        while(itrAllotjament.hasNext()){
            Allotjament allotjament = itrAllotjament.next();
            if(allotjament.getEstat().equals(estat)){
                llista += allotjament.toString();
                n++;
            }
        }
        if(n == 0){
            throw new ExcepcioCamping("Llista de allotjamnets sense cap allotjament amb l'estat pasat. ");
        }
        return llista;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        boolean disponible = false;
        Iterator<Allotjament> itrAllotjaments = allotjaments.iterator();

        while(itrAllotjaments.hasNext()){
            Allotjament allotjament = itrAllotjaments.next();
            if (allotjament.getEstat())
                disponible = true;
        }
        return disponible;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        boolean esta = false;
        Iterator<Allotjament> itrAllotjament = allotjaments.iterator();
        while(itrAllotjament.hasNext()){
            Allotjament allotjamentPos = itrAllotjament.next();
            if(allotjamentPos.equals(allotjament))
                esta = true;
        }
        return esta;

    }

    public Allotjament getAllotjament(String id) throws ExcepcioCamping{

    }
}
