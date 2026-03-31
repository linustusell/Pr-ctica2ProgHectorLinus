package prog2.vista;
import prog2.model.LlistaAllotjaments;
import java.util.Scanner;
import prog2.model.Camping;

public class VistaCamping {

    private static enum OpcionsMenu {
        LLISTAR_ALLOTJAMENTS,
        LLISTAR_OPERATIUS,
        LLISTAR_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_TASQUES,
        AFEGIR_TASCA,
        COMPLETAR_TASCA,
        ACCESSOS_SENSE_VEHICLE,
        METRES_ACCESSOS_TERRA,
        GUARDAR,
        CARREGAR,
        SORTIR
    }

    private static String[] descripcions = {
            "Llistar tots els allotjaments",
            "Llistar allotjaments operatius",
            "Llistar allotjaments no operatius",
            "Llistar accessos oberts",
            "Llistar accessos tancats",
            "Llistar tasques de manteniment actives",
            "Afegir tasca de manteniment",
            "Completar tasca de manteniment",
            "Nombre d'accessos sense vehicle",
            "Metres totals d'accessos de terra",
            "Guardar càmping",
            "Carregar càmping",
            "Sortir"
    };

    private Camping camping;

    public VistaCamping(String nomCamping) {
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }

    LlistaAllotjaments llista = new LlistaAllotjaments();

    public void gestioCamping() {
        Scanner sc = new Scanner(System.in);
        Menu<OpcionsMenu> menu = new Menu<OpcionsMenu>("Menu Càmping Green", OpcionsMenu.values());
        menu.setDescripcions(descripcions);

        menu.mostrarMenu();
        OpcionsMenu opcio = menu.getOpcio(sc);
        while(opcio != OpcionsMenu.SORTIR) {
            switch(opcio) {
                case LLISTAR_ALLOTJAMENTS:
                    try {
                        System.out.println(camping.llistarAllotjaments("tots"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_OPERATIUS:
                    try {
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_NO_OPERATIUS:
                    try {
                        System.out.println(camping.llistarAllotjaments("No Operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ACCESSOS_OBERTS:
                    try {
                        System.out.println(camping.llistarAccessos("Obert"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ACCESSOS_TANCATS:
                    try {
                        System.out.println(camping.llistarAccessos("Tancat"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_TASQUES:
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case AFEGIR_TASCA:
                    try {
                        System.out.print("Número de tasca: ");
                        int num = sc.nextInt(); sc.nextLine();
                        System.out.print("ID allotjament: ");
                        String id = sc.nextLine();
                        System.out.print("Tipus (Reparacio/Neteja/RevisioTecnica/Desinfeccio): ");
                        String tipus = sc.nextLine();
                        System.out.print("Data: ");
                        String data = sc.nextLine();
                        System.out.print("Dies esperats: ");
                        int dies = sc.nextInt(); sc.nextLine();
                        camping.afegirTascaManteniment(num, tipus, id, data, dies);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case COMPLETAR_TASCA:
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                        System.out.print("Número de tasca a completar: ");
                        int num = sc.nextInt(); sc.nextLine();
                        camping.completarTascaManteniment(num);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case ACCESSOS_SENSE_VEHICLE:
                    System.out.println("Accessos sense vehicle: " + camping.calculaAccessosNoAccessibles());
                    break;
                case METRES_ACCESSOS_TERRA:
                    System.out.println("Metres totals accessos de terra: " + camping.calculaMetresTerra());
                    break;
                case GUARDAR:
                    try {
                        System.out.print("Ruta del fitxer: ");
                        String ruta = sc.nextLine();
                        camping.save(ruta);
                        System.out.println("Càmping guardat correctament.");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case CARREGAR:
                    try {
                        System.out.print("Ruta del fitxer: ");
                        String ruta = sc.nextLine();
                        camping = Camping.load(ruta);
                        System.out.println("Càmping carregat correctament.");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
        }
    }
}