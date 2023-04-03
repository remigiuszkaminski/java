import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jest to program do wykonywania obliczen na Walcu.");
        System.out.println("Podaj podstawe: ");
        double a = sc.nextDouble();
        System.out.println("Podaj wysokosc: ");
        double b = sc.nextDouble();
        Walec nowy = new Walec(a, b);
        // System.out.println(nowy.getPodstawa());
        // nowy.setPodstawa(5.4);
        // System.out.println(nowy.getPodstawa());
        // System.out.println(nowy.getWysokosc());
        // nowy.setWysokosc(4.3);
        // System.out.println(nowy.getWysokosc());
        // System.out.println(nowy.liczPolePod());
        // System.out.println(nowy.boczne());
        // System.out.println(nowy.calkowite());
        // System.out.println(nowy.objetosc());
        // System.out.println("Stworzono nowy walec o podstawie: " +a +" oraz wysokosci: " +b );
        int opcja = 1;
        while(opcja != 4){
            System.out.println("Wybierz jedna z opcji: \n" + "1 - Wyswietl wartosci zmiennych instancji klasy Walec \n" + "2 - Zmien Wartosci obiektu klasy Walec \n" + "3 - Oblicz pola powierzchni oraz objetosci obiektu klasy Walec \n" + "4 - Wyjdz z programu \n" );
            opcja = sc.nextInt();
            if (opcja == 1) {
                System.out.println("Podstawa wynosi: " + nowy.getPodstawa() + " a wysokosc: " + nowy.getWysokosc() + "\n");
            } else if (opcja == 2) {
                System.out.println("Zmien wartosci naszego walca:");
                System.out.println("Podaj nowa podstawe: ");
                double nowap = sc.nextDouble();
                nowy.setPodstawa(nowap);
                System.out.println("Podaj nowa wysokosc: ");
                double nowah = sc.nextDouble();
                nowy.setWysokosc(nowah);
                System.out.println("Pomyslnie zmieniono podstawe oraz wysokosc \n");
            } else if (opcja == 3){
                System.out.println("Wyliczone pole podstawy:" + nowy.liczPolePod());
                System.out.println("Wyliczone pole boczne: " + nowy.boczne());
                System.out.println("Wyliczone pole calkowite: " + nowy.calkowite());
                System.out.println("Wyliczona objetosc: " + nowy.objetosc() + "\n");
            } else if (opcja == 4){
                System.out.println("Koniec programu \n");
                System.exit(0);
            } else {
                System.out.println("Zla opcja \n");
            }

        }

    }
    
}

