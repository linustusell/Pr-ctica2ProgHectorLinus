package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static prog2.model.Camping.getTemporada;

public class LlistaReserves{
    private ArrayList<Reserva> reservas;

    public LlistaReserves(){
        reservas = new ArrayList<Reserva>();
    }

    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        Iterator itrReserva = reservas.iterator();
        boolean disponible = true;
        Reserva allotjamentPos;

        while(itrReserva.hasNext()){
            allotjamentPos = (Reserva) itrReserva.next();
            if(allotjamentPos.getAllotjament_().equals(allotjament)){

                LocalDate entradaRes = allotjamentPos.getDataEntrada();
                LocalDate sortidaPos = allotjamentPos.getDataSortida();

                if(dataEntrada.isBefore(sortidaPos) && dataSortida.isAfter(entradaRes))
                    disponible = false;
            }
        }
        return disponible;
    }

    public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        InAllotjament.Temp temporada = getTemporada(dataEntrada);
        long estadaMinima = allotjament.getEstadaMinima(temporada);
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

        if(estada >=  estadaMinima)
            return true;
        else
            return false;
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioCamping {
        boolean disponible = allotjamentDisponible(allotjament, dataEntrada, dataSortida);
        boolean estadaMinima = isEstadaMinima(allotjament, dataEntrada, dataSortida);

        if(!disponible){
            throw new ExcepcioCamping("L'allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada " +  dataEntrada +
                    " pel client " + client.getNom() + " amb DNI: " + client.getDni() + ".");
        } else if (!estadaMinima) {
            throw new ExcepcioCamping("Les fates sol·licitades pel client  "+ client.getNom() + " amb DNI: " + client.getDni() +
                    " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");
        } else{
            Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
            reservas.add(reserva);

            System.out.println("Reserva realitzada amb èxit.");
        }
    }

    @Override
    public int getNumReserves() {
        return reservas.size();
    }
}
