import java.time.LocalTime;
public class Spotkanie {
    public static final LocalTime MIN_TIME = LocalTime.of(8, 0);
    
    private final String opis;
    private final LocalTime poczatek;
    private final LocalTime koniec;
    private final String waznosc;

    public Spotkanie(String opis, LocalTime poczatek, LocalTime koniec, String waznosc) {
        this.opis = opis;
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.waznosc = waznosc;
    }

    public String getWaznosc() {
        return waznosc;
    }

    public String getSpotkanie() {
        return(this.opis + " " + this.poczatek + " " + this.koniec + " " + this.waznosc);
    }
}
