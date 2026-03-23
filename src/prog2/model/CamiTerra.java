package prog2.model;

public class CamiTerra extends AccesTerra{

    public CamiTerra(String nom, boolean obert, int metres) {
        super(nom, obert, metres);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
