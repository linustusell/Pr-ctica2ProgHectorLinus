package prog2.vista;

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

    public void gestioCamping() {
        Scanner sc = new Scanner(System.in);
        Menu<OpcionsMenu> menu = new Menu<OpcionsMenu>("Menu Càmping Green", OpcionsMenu.values());
        menu.setDescripcions(descripcions);

        OpcionsMenu opcio = menu.getOpcio(sc);
        while(opcio != OpcionsMenu.SORTIR) {
            menu.mostrarMenu();
            switch(opcio) {
                case LLISTAR_ALLOTJAMENTS:

                    break;
                     case LLISTAR_OPERATIUS:

                         break;
                         case LLISTAR_NO_OPERATIUS:

                             break;
                             case LLISTAR_ACCESSOS_OBERTS:

                                 break;
                                 case LLISTAR_ACCESSOS_TANCATS:

                                     break;
                                     case LLISTAR_TASQUES:

                                         break;
                                         case AFEGIR_TASCA:

                                             break;
                                             case COMPLETAR_TASCA:

                                                 break;
                                                 case METRES_ACCESSOS_TERRA:

                                                     break;
                                                     case GUARDAR:

                                                         break;
                                                         case CARREGAR:

                                                             break;
                case SORTIR:

                    System.out.println("Fins aviat!");
                    break;
            }
            opcio = menu.getOpcio(sc);
        }
    }
}