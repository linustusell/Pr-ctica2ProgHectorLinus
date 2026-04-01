package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Camping implements InCamping, Serializable {
    private String nom;
    private LlistaAllotjaments allotjaments;
    private LlistaAccessos accessos;
    private LlistaTasquesManteniment tasquesManteniment;
    private ArrayList<Client> clients;

    public Camping(String nom){
        allotjaments = new LlistaAllotjaments();
        accessos = new LlistaAccessos();
        tasquesManteniment = new LlistaTasquesManteniment();
        clients = new ArrayList<Client>();
        this.nom = nom;
    }

    @Override
    public String getNomCamping() {
        return nom;
    }

    public LlistaAllotjaments getLlistaAllotjaments() {
        return allotjaments;
    }

    public ArrayList<Client> getLlistaClients() {
        return clients;
    }

    public int getNumClients() {
        return clients.size();
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


    public void afegirClient(String nom_, String dni_) {
        Client client = new Client(nom_, dni_);

        clients.add(client);
    }

    public void afegirBungalow(String nom_, String idAllotjament_, float mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred) throws ExcepcioCamping{
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_,true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);

        allotjaments.afegirAllotjament(bungalow);
    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, float mida, int habitacions, int placesPersones,
                                      int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                                      boolean serveisExtra, String codiWifi) throws ExcepcioCamping {

        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_,true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa,
                tv, aireFred, serveisExtra, codiWifi);
    }

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean conexioElectrica) throws ExcepcioCamping{
        Parcela parcela = new Parcela(nom_, idAllotjament_, true, "100%", metres, conexioElectrica);
        allotjaments.afegirAllotjament(parcela);
    }

    public void afegirGlamping(String nom_, String idAllotjament_, float mida, int habitacions, int placesPersones,
                              String material, boolean casaMascota) throws ExcepcioCamping{

        Glamping glamping = new Glamping(nom_, idAllotjament_,true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        allotjaments.afegirAllotjament(glamping);
    }

    public void afegirMobilHome(String nom_, String idAllotjament_, float mida,  int habitacions, int placesPersones, boolean terrassaBarbacoa) throws ExcepcioCamping{
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);

        allotjaments.afegirAllotjament(mobilHome);
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        String llista = allotjaments.llistarAllotjaments(estat);
        return llista;
    }

    public String llistarTasquesManteniment() throws ExcepcioCamping {
        String llista = tasquesManteniment.llistarTasquesManteniment();
        return llista;
    }

    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        boolean estat = false;
        if(infoEstat.equals("Operatiu"))
            estat = true;

        String llista = accessos.llistarAccessos(estat);
        return llista;
    }

    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping{
        Allotjament allotjament = allotjaments.getAllotjament(idAllotjament);
        tasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);
    }

    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment tasca = tasquesManteniment.getTascaManteniment(num);
        tasquesManteniment.completarTascaManteniment(tasca);
    }

    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int num = accessos.calculaAccessosNoAccessibles();
        return num;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping{
        float metres = accessos.calculaMetresTerra();
        return metres;
    }

    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        try{
            File fitxer = new File(camiDesti);
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
        }catch(Exception e){
            throw new ExcepcioCamping("Error guardant el càmping.");
        }
    }

    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        try {
            File fitxer = new File(camiOrigen);
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);

            Camping camping = (Camping) ois.readObject();
            ois.close();

            return camping;
        }catch (Exception e){
            throw new ExcepcioCamping("Error carregant el càmping.");
        }

    }

    @Override
    public void inicialitzaDadesCamping() throws ExcepcioCamping{

        accessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfalt("A1", true, asfalt);
        accessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfalt("A2", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        accessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        accessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfalt("A5", true, asfalt);
        accessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfalt("A6", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfalt("A7", true, asfalt);
        accessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfalt("A8", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        accessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        accessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        accessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        accessos.afegirAcces(Acc12);


        /* Pistes */
        allotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        allotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        allotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        allotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        allotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        allotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        allotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);


    }
}
