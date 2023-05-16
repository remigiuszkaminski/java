import java.time.LocalTime;
public final class Zadanie extends Wydarzenie{
    private StatusVal status;
    public static final LocalTime MIN_TIME = LocalTime.of(8, 0);
    enum StatusVal{
        planowanie,potwierdzone,realizowane,wykonane
    }
    public Zadanie(String opis, LocalTime poczatek, LocalTime koniec, String status){
        super(opis, poczatek, koniec);
        this.status = StatusVal.valueOf(status);
    }

    public StatusVal getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "\nopis : " + this.opis + "\ngodzina rozpoczecia: " + this.poczatek + "\ngodzina zakonczenia : " + this.koniec +"\n status spotkania:" +this.status;
    }
    
}
