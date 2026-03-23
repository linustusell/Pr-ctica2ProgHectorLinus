package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

public class Reserva {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;

        if(dataSortida.isBefore(dataEntrada)){
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }
    }

    public Allotjament getAllotjament_() {
        return allotjament;
    }
    public Client getClient() {
        return client;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
    }

    public void setAllotjament_(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }

}
