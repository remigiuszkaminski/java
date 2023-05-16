import java.time.LocalTime;
abstract sealed class Wydarzenie permits Zadanie, Spotkanie{
    
    protected String opis;
    protected LocalTime poczatek;
    protected LocalTime koniec;

    public Wydarzenie(String opis, LocalTime poczatek, LocalTime koniec) {
        this.opis = opis;
        this.poczatek = poczatek;
        this.koniec = koniec;
    }

    public String getOpis() {
        return opis;
    }
    
    public LocalTime getPoczatek() {
        return poczatek;
    }

    public LocalTime getKoniec() {
        return koniec;
    }

    // @Override
    // public String toString() {
    //     return "\napis : " + this.opis + "\ngodzina rozpoczecia: " + this.poczatek + "\ngodzina zakonczenia : " + this.koniec;
    // }
    
}
