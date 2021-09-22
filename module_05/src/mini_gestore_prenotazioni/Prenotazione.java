package mini_gestore_prenotazioni;

public class Prenotazione {
    private String code;
    private int nPosti;

    public Prenotazione(String code, int nPosti) {
        this.code = code;
        this.nPosti = nPosti;
    }

    public String getCode() {
        return code;
    }

    public int getnPosti() {
        return nPosti;
    }

}
