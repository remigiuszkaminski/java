import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Jest to program, który służy do zapisywania wizyt u doktora.");
        Scanner intinput = new Scanner(System.in);
        Scanner stringinput = new Scanner(System.in);

        boolean dzialaj = true;
        int opcja;
        
        Kalendarz kalendarz = new Kalendarz();
        while(dzialaj == true){
            System.out.println("\n 1-Dodaj wizyte \n" + "2-Usun wizyte \n" + "3-Wyswietl wizyte w danym dniu \n" + "4-Wyswietl wizyte w danym dniu o podanej waznoscu \n" + "5-Wyjście z programu \n");
            opcja = intinput.nextInt();
            switch(opcja) {
                case 1:
                    dodajMeeta(kalendarz, intinput, stringinput);
                    break;
                case 2:
                    usunMeeta(kalendarz, intinput);
                    break;
                case 3:
                    wyswietlWizytyDzien(kalendarz, intinput);
                    break;
                case 4:
                    wyswietlWizytyDzienPriorytet(kalendarz, intinput, stringinput);
                    break;
                case 5:
                    dzialaj = false;
                    break;
                default:
                    System.out.println("Bledna opcja- nie podano takiej \n");
                    break;
                    

            }
        }
    }

    public static void dodajMeeta(Kalendarz kalendarz, Scanner intinput, Scanner stringinput) {
        System.out.print("Podaj dzien, w ktorym chcesz dodac spotkanie : ");
        int dzien = intinput.nextInt() - 1;
        System.out.print("Podaj opis spotkania : ");
        String opis = stringinput.nextLine();
        System.out.print("Podaj godzine rozpoczecia : ");
        String przybycie = stringinput.nextLine();
        System.out.print("Podaj godzine zakonczenia : ");
        String koniec = stringinput.nextLine();
        System.out.print("Podaj priorytet : ");
        String waznosc = stringinput.nextLine();
        if(LocalTime.parse(przybycie).compareTo(Spotkanie.MIN_TIME) >= 0)
            kalendarz.dodajSpotkanie(dzien, new Spotkanie(opis, LocalTime.parse(przybycie), LocalTime.parse(koniec), waznosc));
        else
            System.out.println("Godzina rozpoczecia jest za wczesna");
        
    }

    public static void usunMeeta(Kalendarz kalendarz, Scanner intinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        System.out.println("Podaj numer spotkania : ");
        int number = intinput.nextInt();
        kalendarz.usunSpotkanie(day, number);
    }

    public static void wyswietlWizytyDzien(Kalendarz kalendarz, Scanner intinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        pokazWizyty(kalendarz.getSpotkania(day));
        
        
    }

    public static void wyswietlWizytyDzienPriorytet(Kalendarz kalendarz, Scanner intinput, Scanner stringinput) {
        System.out.println("Podaj dzien spotkania : ");
        int day = intinput.nextInt() - 1;
        System.out.println("Podaj priorytet spotkania : ");
        String waznosc = stringinput.nextLine();
        pokazWizyty(kalendarz.getWaznoscDzien(day, waznosc));
    }

    public static void pokazWizyty(ArrayList<Spotkanie> info) {
        for(Spotkanie spotkania : info) {
            System.out.println(spotkania.getSpotkanie());
        }
    }
}

