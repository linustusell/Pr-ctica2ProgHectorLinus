package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

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

    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping{

    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return false;
    }

    public Allotjament getAllotjament(String id) throws ExcepcioCamping{

    }
}
