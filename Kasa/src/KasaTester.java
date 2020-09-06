import java.io.IOException;
import java.util.Scanner;

public class KasaTester {
    public static void main(String[] args) throws IOException {
        Operator operator = new Operator();
        Scanner operacja = new Scanner(System.in);
        String op = " ";
        while (true) {
            System.out.println("Witamy w programie Kasa v.1.0");
            System.out.println("Wybierz operacje do wykonania ");
            System.out.println("paragon || dodaj || wyswietl produkt || wyswietl wszystko || zapisz || wczytaj || usun || zakoncz");
            op=operacja.nextLine();
            if (op.equals("dodaj"))
            operator.dodajProdukt();
            else if (op.equals("wyswietl"))
            operator.wyswietlPoKodzie();
            else if (op.equals("zapisz"))
            operator.zapiszPrace();
            else if (op.equals("zakoncz"))
            {
                System.out.println("Praca zostala zakonczona");
                break;
            }
            else if (op.equals("wczytaj"))
                operator.wczytajPrace();
            else if (op.equals("usun"))
                operator.usunProdukt();
            else if (op.equals("wyswietl wszystko"))
                operator.wyswietlWszystko();
            else if (op.equals("paragon"))
                operator.kasuj();
            else
                System.out.println("Nie znam takiej komendy, sprobuj ponownie");
        }

    }
}
