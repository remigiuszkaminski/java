import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Jest to program, który służy do zapisywania wizyt u doktora.");
        Scanner intinput = new Scanner(System.in);
        Scanner stringinput = new Scanner(System.in);

        boolean dzialaj = true;
        int opcja;
        
        Kalendarz kalendarz = new Kalendarz();
        while(dzialaj == true){
            System.out.println("\n 1-Dodaj wizyte \n" + "2-Usun wizyte \n" + "3-Wyswietl spotkania w danym dniu \n" + "4-Wyswietl zadanie w danym dniu \n" + "5-Wyswietl spotkanie w danym dniu o podanym priorytecie \n" + "6-Wyswietlenie zadania o wybranym statusie \n" + "7-Wizyta w danym dniu o wybranym priorytecie oraz od podanego czasu\n" + "8-Zadanie w danym dniu o wybranym statusie do pewnej godzinie \n" + "9- zakończ program \n");
            opcja = intinput.nextInt();
            switch(opcja) {
                case 1:
                    dodajMeeta(kalendarz, intinput, stringinput);
                    break;
                case 2:
                    usunMeeta(kalendarz, intinput, stringinput);
                    break;
                case 3:
                    wyswieltSpotkaniaDanyDzien(kalendarz, intinput);
                    break;
                case 4:
                    wyswietlZadaniaDanyDzien(kalendarz, intinput);
                    break;
                case 5:
                    wyswietlSpotkniaDzienPriorytet(kalendarz, intinput, stringinput);
                    break;
                case 6:
                    wyswieltZadanieDzienStatus(kalendarz, intinput, stringinput);
                    break;
                case 7:
                    wyswieltSpotkaniaDzienPriorytetOdGodziny(kalendarz, intinput, stringinput);
                    break;
                case 8:
                    wyswietlZadanieDzienStatusDoGodziny(kalendarz, intinput, stringinput);
                    break;
                case 9:
                    dzialaj = false;
                    break;
                default:
                    System.out.println("Bledna opcja- nie podano takiej \n");
                    break;
                    

            }
        }
    }

    public static void dodajMeeta(Kalendarz kalendarz, Scanner intinput, Scanner stringinput) {
        System.out.println("Podaj, czy ma to byc spotkanie czy zadanie : ");
        String wybor = stringinput.nextLine();
        System.out.print("Podaj dzien, w ktorym chcesz dodac wydarzenie : ");
        int dzien = intinput.nextInt() - 1;
        System.out.print("Podaj opis wydarzenia : ");
        String opis = stringinput.nextLine();
        System.out.print("Podaj godzine rozpoczecia : ");
        String przybycie = stringinput.nextLine();
        System.out.print("Podaj godzine zakonczenia : ");
        String koniec = stringinput.nextLine();
        System.out.print("Podaj priorytet/status : ");
        String waznosc = stringinput.nextLine();
        if(wybor.equals("zadanie"))
            if(LocalTime.parse(przybycie).compareTo(Zadanie.MIN_TIME) >= 0)
                kalendarz.dodajSpotkanie(dzien, new Zadanie(opis, LocalTime.parse(przybycie), LocalTime.parse(koniec), waznosc));
            else
                System.out.println("Godzina rozpoczecia jest za wczesna");
        else
            if(LocalTime.parse(przybycie).compareTo(Spotkanie.MIN_TIME) >= 0)
                kalendarz.dodajSpotkanie(dzien, new Spotkanie(opis, LocalTime.parse(przybycie), LocalTime.parse(koniec), waznosc));
            else
                System.out.println("Godzina rozpoczecia jest za wczesna");
        
    }

    public static void usunMeeta(Kalendarz kalendarz, Scanner intinput, Scanner stringinput) {
        System.out.println("Podaj dzien wydarzenia : ");
        int day = intinput.nextInt() - 1;
        System.out.println("Podaj typ wydarzenia : 1-Spotkanie, 2-Zadanie ");
        int wybor = intinput.nextInt();
        System.out.println("Podaj opis wydarzenia : ");
        String opis = stringinput.nextLine();

        kalendarz.usunSpotkanie(day, opis, wybor);
    }
    
    public static void wyswieltSpotkaniaDanyDzien(Kalendarz kalendarz, Scanner intinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        Predicate<Wydarzenie> spotkaniaDzien = e -> e instanceof Spotkanie;
        pokazWizyty(kalendarz.getDzien(day, spotkaniaDzien));
        
    }

    public static void wyswietlZadaniaDanyDzien(Kalendarz kalendarz, Scanner intinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        Predicate<Wydarzenie> zadaniaDzien = e -> e instanceof Zadanie;
        pokazWizyty(kalendarz.getDzien(day, zadaniaDzien));
        
    }

    public static void wyswietlSpotkniaDzienPriorytet(Kalendarz kalendarz, Scanner intinput, Scanner stringinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        System.out.println("Podaj priorytet spotkania : ");
        String waznosc = stringinput.nextLine();
        Predicate<Wydarzenie> spotkaniaDzienPriorytet = e -> e instanceof Spotkanie && ((Spotkanie )e).getWaznosc().equals(Spotkanie.PriorytetVal.valueOf(waznosc));
        pokazWizyty(kalendarz.getDzien(day, spotkaniaDzienPriorytet));
    }
    
   public static void wyswieltZadanieDzienStatus(Kalendarz kalendarz, Scanner intinput, Scanner stringinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        System.out.println("Podaj status zadania : ");
        String status = stringinput.nextLine();
        Predicate<Wydarzenie> zadaniaDzienStatus = e -> e instanceof Zadanie && ((Zadanie )e).getStatus().equals(Zadanie.StatusVal.valueOf(status));
        pokazWizyty(kalendarz.getDzien(day, zadaniaDzienStatus));
    }

    public static void wyswieltSpotkaniaDzienPriorytetOdGodziny(Kalendarz kalendarz, Scanner intinput, Scanner stringinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        System.out.println("Podaj priorytet spotkania : ");
        String waznosc = stringinput.nextLine();
        System.out.println("Podaj godzine rozpoczecia : ");
        String przybycie = stringinput.nextLine();
        Predicate<Wydarzenie> spotkaniaDzienPriorytetOdGodziny = e -> e instanceof Spotkanie && ((Spotkanie )e).getWaznosc().equals(Spotkanie.PriorytetVal.valueOf(waznosc)) && e.getPoczatek().compareTo(LocalTime.parse(przybycie)) >= 0;
        pokazWizyty(kalendarz.getDzien(day, spotkaniaDzienPriorytetOdGodziny));
    }

    public static void wyswietlZadanieDzienStatusDoGodziny(Kalendarz kalendarz, Scanner intinput, Scanner stringinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        System.out.println("Podaj status zadania : ");
        String status = stringinput.nextLine();
        System.out.println("Podaj do ktorej godziny : ");
        String przybycie = stringinput.nextLine();
        Predicate<Wydarzenie> zadaniaDzienStatusDoGodziny = e -> e instanceof Zadanie && ((Zadanie )e).getStatus().equals(Zadanie.StatusVal.valueOf(status)) && e.getKoniec().compareTo(LocalTime.parse(przybycie)) <= 0;
        pokazWizyty(kalendarz.getDzien(day, zadaniaDzienStatusDoGodziny));
    }

    public static void pokazWizyty(ArrayList<Wydarzenie> info) {
        for(Wydarzenie spotkania : info) {
            System.out.println(spotkania.toString());
        }
    }
}

