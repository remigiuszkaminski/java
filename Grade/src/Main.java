import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jest to program do operacji na array.");
        GradeList nowy = new GradeList();
        int opcja;
        boolean program = true;
        while(program == true) {
            System.out.println("Wybierz jedna z opcji: \n" + "1 - Dodaj nowa ocene \n" + "2 - Policz srednia \n" + "3 - Podaj najwyzsza ocene \n" + "4 - Podaj najnizsza ocene \n" + "5 - Wyjdz z programu \n" );
            opcja = sc.nextInt();
            switch (opcja) {
                case 1:
                    System.out.println("Podaj nowa ocene:");
                    double nowaocena = sc.nextDouble();
                    nowy.addOcena(nowaocena);
                    break;
                case 2:
                    double srednia = nowy.sredniaOcen();
                    if(srednia == 0) System.out.println("Błąd, brak ocen w liście");
                    else System.out.println("Srednia ocen wynosi : " + srednia);
                    break;
                case 3:
                    double najwyzszy = nowy.najwyzszaOcena();
                    if(najwyzszy == 0) System.out.println("Błąd, brak ocen w liście");
                    else System.out.println("Najwyzsza ocena wynosi : " + najwyzszy);
                    break;
                case 4:
                    double najnizszy = nowy.najnizszaOcena();
                    if(najnizszy == 0) System.out.println("Błąd, brak ocen w liście");
                    else System.out.println("Najnizsza ocena wynosi : " + najnizszy);
                    break;
                case 5:
                    System.out.println("Koniec programu \n");
                    sc.close();
                    program = false;
                    break;
                 default:
                    System.out.println("Zla opcja \n");
                    break;
            }
        }

//a
    }
}


