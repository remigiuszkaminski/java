import java.time.LocalTime;
public final class Spotkanie extends Wydarzenie{
    public static final LocalTime MIN_TIME = LocalTime.of(8, 0);
    
    private PriorytetVal waznosc;

    enum PriorytetVal{
        niski,normalny,wysoki
    }

    public Spotkanie(String opis, LocalTime poczatek, LocalTime koniec, String waznosc){
        super(opis, poczatek, koniec);
        this.waznosc = PriorytetVal.valueOf(waznosc);
    }

    public PriorytetVal getWaznosc(){
        return waznosc;
    }

    @Override
    public String toString() {
        return "\nopis : " + this.opis + "\ngodzina rozpoczecia: " + this.poczatek + "\ngodzina zakonczenia : " + this.koniec + "\nWaznosc spotkania : " + this.waznosc;
    }
}
