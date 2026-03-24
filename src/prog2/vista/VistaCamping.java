package prog2.vista;


import prog2.model.Camping;

public class VistaCamping {

    private Camping camping;
    public static enum llistaOpcions{
        Llistar_la_informació_de_tots_els_allotjaments, Llistar_la_informació_dels_allotjaments_operatius,
        Llistar_la_informació_dels_allotjaments_no_operatius, Llistar_la_informació_dels_accessos_oberts,
        Llistar_la_informació_dels_accessos_tancats, Llistar_la_informació_de_les_tasques_de_manteniments_actives,
        Afegir_una_tasca_de_manteniment, Completar_una_tasca_de_manteniment,
        Calcular_i_mostrar_el_número_total_daccessos_que_NO_proporcionen_accessibilitat_amb_vehicle
    }
    public VistaCamping(Camping camping) {

        this.camping = camping;

    }

    public void gestioCamping(){

        Menu menu = new Menu(llistaOpcions);
    }
}
