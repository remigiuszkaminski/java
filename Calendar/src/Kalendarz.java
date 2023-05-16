import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {

    private final ArrayList<ArrayList<Spotkanie>> spotkania;

    public Kalendarz() {
        this(7);
    }

    public Kalendarz(int maks) {
        this.spotkania = new ArrayList<>();
        for (int i = 0; i < maks; i++) {
            this.spotkania.add(new ArrayList<>());
        }
    }

    public void dodajSpotkanie(int dzien, Spotkanie spotkanie) {
        this.spotkania.get(dzien).add(spotkanie);
    }

    public void usunSpotkanie(int dzien, int index) {
        this.spotkania.get(dzien).remove(index);
    }

    public ArrayList<Spotkanie> getSpotkania(int dzien) {
        return this.spotkania.get(dzien);
    }

    public Predicate<Spotkanie> getSpotkaniaDzien(int dzien) {
        return e -> true;
    }

    public Predicate<Spotkanie> getSpotkaniaOdGodziny(LocalTime start) {
        return e -> e.getPoczatek().compareTo(start) >= 0;
    }

    public Predicate<Spotkanie> getWaznosc(String waznosc) {
        return (Spotkanie spotkanie) -> spotkanie.getWaznosc().equals(waznosc);
    }

    public Predicate<Spotkanie> getWaznoscGodzina(String waznosc, LocalTime start) {
        return e -> e.getWaznosc().equals(waznosc) && e.getPoczatek().compareTo(start) >= 0;
    }

    public Predicate<Spotkanie> getOdGodzinyDoGodziny(LocalTime start, LocalTime end) {
        return e -> e.getPoczatek().compareTo(start) >= 0 && e.getKoniec().compareTo(end) <= 0;
    }

    public ArrayList<Spotkanie> getDzien(int dzien, Predicate<Spotkanie> condition) {
        ArrayList<Spotkanie> wazne = new ArrayList<>();
        for (Spotkanie spotkanie : this.spotkania.get(dzien)) {
            if (condition.test(spotkanie)) {
                wazne.add(spotkanie);
            }
        }
        return wazne;
    }
    
}
