import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {

    private final ArrayList<ArrayList<Wydarzenie>> spotkania;

    public Kalendarz() {
        this(7);
    }

    public Kalendarz(int maks) {
        this.spotkania = new ArrayList<>();
        for (int i = 0; i < maks; i++) {
            this.spotkania.add(new ArrayList<>());
        }
    }

    public void dodajSpotkanie(int dzien, Wydarzenie spotkanie) {
        this.spotkania.get(dzien).add(spotkanie);
    }

    public void usunSpotkanie(int dzien, String opis, int numer) {
        for (int i = 0; i < this.spotkania.get(dzien).size();) {
            if (this.spotkania.get(dzien).get(i).getOpis().equals(opis) && this.spotkania.get(dzien).get(i) instanceof Spotkanie && numer == 1) {
                this.spotkania.get(dzien).remove(i);
                break;
            }
            else if (this.spotkania.get(dzien).get(i).getOpis().equals(opis) && this.spotkania.get(dzien).get(i) instanceof Zadanie && numer == 2) {
                this.spotkania.get(dzien).remove(i);
                break;
            }
            else
                System.out.println("Nie ma takiego wydarzenia");
                break;

        }
        
    }

    public ArrayList<Wydarzenie> getSpotkania(int dzien) {
        return this.spotkania.get(dzien);
    }


    public ArrayList<Wydarzenie> getDzien(int dzien, Predicate<Wydarzenie> condition) {
        ArrayList<Wydarzenie> wazne = new ArrayList<>();
        for (Wydarzenie spotkanie : this.spotkania.get(dzien)) {
            if (condition.test(spotkanie)) {
                wazne.add(spotkanie);
            }
        }
        return wazne;
    }
    
}
