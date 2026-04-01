package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos {
    private ArrayList<Acces> accesos;

    public LlistaAccessos(){
        accesos = new ArrayList<>();
    }
    public void afegirAcces(Acces acces) throws ExcepcioCamping {
        accesos.add(acces);
    }
    public void buidar(){
        Iterator<Acces> itrAccesos = accesos.iterator();
        while(itrAccesos.hasNext()){
            itrAccesos.next();
            itrAccesos.remove();
        }
    }

    public String llistarAccessos(boolean estat) throws ExcepcioCamping{
        String llista = ""; int n = 0;
        Iterator<Acces> itrAccesos = accesos.iterator();
        while(itrAccesos.hasNext()){
            Acces acces = itrAccesos.next();
            if(acces.getEstat() == estat){
                llista += acces.toString();
                n++;
            }
        }
        if(n == 0){
            throw  new  ExcepcioCamping("Llista de accesos sense cap acces amb l'estat pasat. ");
        }
        return llista;
    }

    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        if (accesos.isEmpty()) {
            throw new ExcepcioCamping("La llista d'accesos esta buida.");
        }
        int total = 0;
        Acces acces = null;
        Iterator itrAccesos = accesos.iterator();
        while(itrAccesos.hasNext()){
            if(!acces.isAccessibilitat())
                total++;
        }
        if(total == 0){
            throw new ExcepcioCamping("No hi ha accessos no disponibles");
        }
        return total;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        if (accesos.isEmpty())
            throw new ExcepcioCamping("La llista d'accesos està buida.");

        float metres = 0;
        Iterator<Acces> itrAccesos = accesos.iterator();
        while(itrAccesos.hasNext()){
            Acces acces = itrAccesos.next();
            if(acces instanceof AccesTerra)
                metres += ((AccesTerra) acces).getMetresQuadrat();
        }
        return metres;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator<Acces> itrAccesos = accesos.iterator();
        while( itrAccesos.hasNext()){
            Acces acces = itrAccesos.next();
            LlistaAllotjaments llistaAllotjaments = acces.getAAllotjaments();

            if(accesos.isEmpty())
                throw new ExcepcioCamping("La llista d'accesos està buida.");

            if(acces.getEstat() && !llistaAllotjaments.containsAllotjamentOperatiu())
                acces.tancarAcces();
            else
                acces.tancarAcces();
        }
    }
}
