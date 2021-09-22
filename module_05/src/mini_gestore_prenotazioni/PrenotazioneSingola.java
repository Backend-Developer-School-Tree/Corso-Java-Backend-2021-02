package mini_gestore_prenotazioni;

public class PrenotazioneSingola extends Prenotazione {

    private Preferenza preferenza;
    public PrenotazioneSingola(String code, Preferenza preferenza) {
        super(code, 1);
        this.preferenza = preferenza;
    }

    public Preferenza getPreferenza() {
        return preferenza;
    }
}