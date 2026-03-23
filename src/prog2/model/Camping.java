package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.*;
import java.time.LocalDate;

public class Camping implements InCamping{
    private String nom;
    private ArrayList<Allotjament> allotjamentsDisponibles ;
    private LlistaReserves reserves;
    private ArrayList<Client> clients;

    public Camping(String nom){
        allotjamentsDisponibles = new  ArrayList<Allotjament>();
        clients = new ArrayList<Client>();
        reserves =  new LlistaReserves();
        this.nom = nom;
    }

    @Override
    public String getNomCamping() {
        return nom;
    }
    @Override
    public LlistaReserves getLlistaReserves() {
        return reserves;
    }
    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return allotjamentsDisponibles;
    }
    @Override
    public ArrayList<Client> getLlistaClients() {
        return clients;
    }

    @Override
    public int getNumAllotjaments() {
        return allotjamentsDisponibles.size();
    }

    @Override
    public int getNumReserves() {
        return reserves.getNumReserves();
    }

    @Override
    public int getNumClients() {
        return clients.size();
    }

    public Allotjament buscarAllotjament(String id){
        Iterator itrAllotjament = allotjamentsDisponibles.iterator();

        while(itrAllotjament.hasNext()){
            Allotjament allotjament = (Allotjament)itrAllotjament.next();
            if(allotjament.getId().equals(id)){
                return allotjament;
            }
        }
        return null;
    }

    public Client buscarClient(String dni){
        Iterator itrClient = clients.iterator();

        while(itrClient.hasNext()){
            Client client = (Client)itrClient.next();
            if(client.getDni().equals(dni)){
                return client;
            }
        }
        return null;
    }
    public static InAllotjament.Temp getTemporada(LocalDate data){
        int dia = data.getDayOfMonth();
        int mes =  data.getMonthValue();

        if((mes >  3 &&  mes < 9) || (mes == 3 && dia >= 21) || (mes == 9 && dia <= 20))
            return InAllotjament.Temp.ALTA;

        else
            return InAllotjament.Temp.BAIXA;
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioCamping {
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);

        if(allotjament == null)
            throw new ExcepcioCamping("L'allotjament amb id " + id_ + " no existeix");
        else if (client == null)
            throw new ExcepcioCamping("El client amb DNI " + dni_ + " no existeix");
        else
            reserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    @Override
    public void afegirClient(String nom_, String dni_) {
        Client client = new Client(nom_, dni_);

        clients.add(client);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);

        allotjamentsDisponibles.add(bungalow);
    }
    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                      int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                                      boolean serveisExtra, String codiWifi){

        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa,
                tv, aireFred, serveisExtra, codiWifi);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean conexioElectrica){
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, conexioElectrica);
        allotjamentsDisponibles.add(parcela);
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                              String material, boolean casaMascota){

        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        allotjamentsDisponibles.add(glamping);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);

        allotjamentsDisponibles.add(mobilHome);
    }

    @Override
    public int calculAllotjamentsOperatius() {
        Iterator<Allotjament> iterator = allotjamentsDisponibles.iterator();
        int contador = 0;
        while(iterator.hasNext()){
            Allotjament allotjament = iterator.next();
            if(allotjament.correcteFuncionament())
                contador++;
        }

        return contador;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        Iterator<Allotjament> iterator = allotjamentsDisponibles.iterator();
        long estadaMesCurta = 10;
        Allotjament allotjament = null;
        while(iterator.hasNext()){
            Allotjament posAllotjament = iterator.next();
            if(posAllotjament.getEstadaMinima(temp) < estadaMesCurta){
                estadaMesCurta = posAllotjament.getEstadaMinima(temp);
                allotjament = posAllotjament;
            }
        }
        return allotjament;
    }
}
