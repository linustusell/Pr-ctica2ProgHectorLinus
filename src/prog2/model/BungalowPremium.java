package prog2.model;

/**
 * Funciona correctament si té aire fred i el codi Wifi té entre 8 i 16 caràcters.
 */
public class BungalowPremium extends Bungalow {

    private boolean serveisExtra;
    private String codiWifi;

    public BungalowPremium(String nom, String id,
                           String mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi) {
        super(nom, id, mida, habitacions, placesPersones,
                placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    public boolean isServeisExtra() { return serveisExtra; }
    public void setServeisExtra(boolean serveisExtra) { this.serveisExtra = serveisExtra; }

    public String getCodiWifi() { return codiWifi; }
    public void setCodiWifi(String codiWifi) { this.codiWifi = codiWifi; }

    @Override
    public boolean correcteFuncionament() {
        if (!super.correcteFuncionament() && codiWifi.length() >= 8 && codiWifi.length() <= 16){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", BungalowPremium{serveisExtra=" + serveisExtra +
                ", codiWifi=" + codiWifi + "}";
    }
}
