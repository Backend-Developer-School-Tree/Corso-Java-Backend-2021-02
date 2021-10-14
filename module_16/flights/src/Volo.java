public class Volo {
    private String numeroVolo, partenza, destinazione, pilota, aereo;

    public Volo(String numeroVolo, String partenza, String destinazione, String pilota, String aereo) {
        this.numeroVolo = numeroVolo;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.pilota = pilota;
        this.aereo = aereo;
    }

    public String getNumeroVolo() {
        return numeroVolo;
    }

    public void setNumeroVolo(String numeroVolo) {
        this.numeroVolo = numeroVolo;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getPilota() {
        return pilota;
    }

    public void setPilota(String pilota) {
        this.pilota = pilota;
    }

    public String getAereo() {
        return aereo;
    }

    public void setAereo(String aereo) {
        this.aereo = aereo;
    }

    @Override
    public String toString() {
        return "Volo{" +
                "numeroVolo='" + numeroVolo + '\'' +
                ", partenza='" + partenza + '\'' +
                ", destinazione='" + destinazione + '\'' +
                ", pilota='" + pilota + '\'' +
                ", aereo='" + aereo + '\'' +
                '}';
    }
}
