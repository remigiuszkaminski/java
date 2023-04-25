import java.util.ArrayList;

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

    public ArrayList<Spotkanie> getWaznoscDzien(int dzien, String waznosc) {
        ArrayList<Spotkanie> wazne = new ArrayList<>();
        for (Spotkanie spotkanie : this.spotkania.get(dzien)) {
            if (spotkanie.getWaznosc().equals(waznosc)) {
                wazne.add(spotkanie);
            }
        }
        return wazne;
    }
    
}
