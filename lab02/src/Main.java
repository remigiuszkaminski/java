import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jest to program do wykonywania obliczen na Walcu.");
        Walec nowy = new Walec();
        int opcja;
        while(true) {
            System.out.println("Wybierz jedna z opcji: \n" + "1 - Wyswietl wartosci zmiennych instancji klasy Walec \n" + "2 - Zmien Wartosci obiektu klasy Walec \n" + "3 - Oblicz pola powierzchni oraz objetosci obiektu klasy Walec \n" + "4 - Wyjdz z programu \n" );
            opcja = sc.nextInt();
            switch (opcja) {
                case 1:
                    System.out.println("Promien wynosi: " + nowy.getPodstawa() + " a wysokosc: " + nowy.getWysokosc() + "\n");
                    break;
                case 2:
                    System.out.println("Zmien wartosci naszego walca: Na poczatek podaj nowy promien, a nastepnie nowa wysokosc: \n");
                    double nowyr = sc.nextDouble();
                    double nowah = sc.nextDouble();
                    nowy.setPodstawa(nowyr);
                    nowy.setWysokosc(nowah);
                    break;
                case 3:
                    System.out.println("Wyliczone pole podstawy:" + nowy.liczPolePod() + "\n Wyliczone pole boczne: " + nowy.boczne() + "\n Wyliczone pole calkowite: " + nowy.calkowite() + "\n Wyliczona objetosc: " + nowy.objetosc() + "\n");
                    break;
                case 4:
                    System.out.println("Koniec programu \n");
                    sc.close();
                    System.exit(0);
                case default:
                    System.out.println("Zla opcja \n");
                    break;
                }
            }
    }
}

