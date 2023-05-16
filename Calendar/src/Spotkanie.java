import java.time.LocalTime;
public class Spotkanie {
    public static final LocalTime MIN_TIME = LocalTime.of(8, 0);
    
    private String opis;
    private LocalTime poczatek;
    private LocalTime koniec;
    private String waznosc;

    public Spotkanie(String opis, LocalTime poczatek, LocalTime koniec, String waznosc) {
        this.opis = opis;
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.waznosc = waznosc;
    }

    public String getWaznosc() {
        return waznosc;
    }
    
    public LocalTime getPoczatek() {
        return poczatek;
    }

    public LocalTime getKoniec() {
        return koniec;
    }

    @Override
    public String toString() {
        return "\nopis : " + this.opis + "\ngodzina rozpoczecia: " + this.poczatek + "\ngodzina zakonczenia : " + this.koniec + "\nWaznosc spotkania : " + this.waznosc;
    }
}
