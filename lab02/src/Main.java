public class Main {
    public static void main(String[] args) {
        Walec nowy = new Walec(2.5, 2.5);
        System.out.println(nowy.getPodstawa());
        nowy.setPodstawa(5.4);
        System.out.println(nowy.getPodstawa());
        System.out.println(nowy.getWysokosc());
        nowy.setWysokosc(4.3);
        System.out.println(nowy.getWysokosc());
        System.out.println(nowy.liczPolePod());
        System.out.println(nowy.boczne());
        System.out.println(nowy.calkowite());
        System.out.println(nowy.objetosc());
    }
    
}

