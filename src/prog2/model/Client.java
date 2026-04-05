package prog2.model;

public class Client {
    private String nom;
    private String dni;

    public Client(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }
    public String getDni() {
        return dni;
    }


    public String toString(){
        return  nom + " amb DNI: " + dni+". ";
    }
}
