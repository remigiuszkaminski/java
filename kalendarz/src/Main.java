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
        while(dzialaj == true){
            System.out.println("Wybierz jedną z opcji: \n" + "1 - Dodaj wizytę \n" + "2 - Usuń wizytę \n" + "3 - Wyświetl wizyty w danym dniu \n" + "4 - Wyświetlenie wizytu w danym dniu o danym priorytecie \n" + "5 - Wyjście z programu \n");
            opcja = intinput.nextInt();
            switch(opcja) {
                case 1:
                    dodajMeeta(null, intinput, stringinput);
                case 2:
                    

            }
        }

        public static void dodajMeeta(Kalendarz kalendarz, Scanner intinput, Scanner stringinput){
            System.out.println("Podaj dzień wizyty: ");
            String dzien = intinput.nextLine();
            System.out.println("Podaj godzinę wizyty: ");
            String godzina = stringinput.nextLine();
            System.out.println("Podaj godzine zakonczenia wizyty: ");
            String godzinazak = stringinput.nextLine();
            System.out.println("Podaj priorytet wizyty: ");
            String priorytet = stringinput.nextLine();
            System.out.println("Podaj opis wizyty: ");
            String opis = stringinput.nextLine();
            if(LocalTime.parse(godzina).compareTo(Spotkanie.MIN_TIME) >= 0){
                Kalendarz.dodajSpotkanie(dzien, new Spotkanie(opis, LocalTime.parse(godzina), LocalTime.parse(godzinazak), priorytet));
            } else{
                System.out.println("Podana godzina jest za wczesna na umówienie wizyty. \n");
            }
        }
}
}

