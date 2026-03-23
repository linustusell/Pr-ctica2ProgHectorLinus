package prog2.model;

public class Client implements InClient{
    private String nom;
    private String dni;

    public Client(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }
    public String getDni() {
        return dni;
    }

    @Override
    public String toString(){
        return  nom + " amb DNI: " + dni+". ";
    }
}
