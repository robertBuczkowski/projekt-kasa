import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Operator implements Serializable {
    ArrayList<Produkt> listaProduktow = new ArrayList<Produkt>();
    ArrayList<Produkt> temp = new ArrayList<>();
    Scanner scan = new Scanner(System.in);


    public void dodajProdukt() throws IOException {
        while (true) {
           try {
               System.out.println("Podaj parametry produktu");
               scan.reset();
               System.out.println("Nazwa: ");
               String nazwa = scan.nextLine();
               System.out.println("Kod kreskowy: ");
               int kodKreskowy = scan.nextInt();
               System.out.println("Cena:");
               float cena = scan.nextFloat();
               System.out.println("Waga: ");
               float waga = scan.nextFloat();
               if (cena <0 || waga <0){
                   System.out.println("Cena i waga nie może być mniejsze od zera, podaj prawidlową cenę");
                   //dodajProdukt();
               }   else
                   listaProduktow.add(new Produkt(nazwa, cena, waga, kodKreskowy));

           } catch (InputMismatchException | IndexOutOfBoundsException e) {
               System.out.println("Podaj prawidlowo sformatowane dane, pamietaj, ze cena powinna miec format x,xx");
               dodajProdukt();
           }
            System.out.println("Ostatni dodany produkt to:  " + listaProduktow.get(listaProduktow.size() - 1).getNazwa());
            System.out.println("Dodac nastepny produkt? y/n ");
            scan.nextLine();
            String decyzja = scan.nextLine();
            if (decyzja.toLowerCase().equals("n")){
                zapiszPrace();
                break;
            }

        }
    }

    public void wyswietlPoKodzie() {
        wczytajPrace();
        boolean znaleziony = false;
        System.out.println("Podaj szukany kod kreskowy");
        int kodKreskowy = scan.nextInt();
        for (Produkt x : temp)
            if (x.getKodKreskowy() == kodKreskowy) {
                System.out.println("Produkt o danym kodzie to: " + x.getNazwa() + " o cenie " + x.getCena());
                znaleziony = true;
}           if (!znaleziony)
            System.out.println("Nie znaleziono takiego produktu");


        }

    public void zapiszPrace() throws IOException {
        wczytajPrace();
        boolean b = temp.addAll(listaProduktow);
        if (b)
            System.out.println("Pomyślnie wczytano poprzednią baze danych");
        try {
            FileOutputStream fos = new FileOutputStream("produkty");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(temp);
            oos.flush();
            oos.close();
            fos.close();
            System.out.println("Zapisano prace, mozesz bezpiecznie zamknac program.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void wczytajPrace(){
        try {
            FileInputStream fis = new FileInputStream("produkty");
            ObjectInputStream ois = new ObjectInputStream(fis);
            temp = (ArrayList<Produkt>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void usunProdukt() throws IOException {
        wczytajPrace();
        System.out.println("Podaj kod produktu do usunięcia ");
        try {
            int kod = scan.nextInt();
            temp.removeIf(n -> (n.getKodKreskowy()==kod));
            FileOutputStream fos = new FileOutputStream("produkty");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(temp);
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (InputMismatchException e){
            System.out.println("Podaj prawidłowy kod produktu");
        }
        System.out.println("Usunięto produkt");

    }

    public void wyswietlWszystko(){
        wczytajPrace();
        System.out.println("Wszytkie produkty w bazie to: ");
        for (Produkt x :temp)
            System.out.println("Nazwa: " + x.getNazwa() + " Cena: " + x.getCena() + " Waga: " + x.getWaga() + " Kod kreskowy: " + x.getKodKreskowy());
    }

    public void kasuj(){
        wczytajPrace();
        Scanner kod = new Scanner(System.in);
        float cenaKoncowa = 0;
        while (true) {
            System.out.println("Podaj kod produktu");
            int kasowany = kod.nextInt();
            for (Produkt x : temp)
                if (x.getKodKreskowy() == kasowany)
                    cenaKoncowa = cenaKoncowa + x.getCena();
            System.out.println("Kontynuowac kasowanie? y/n");
            kod.nextLine();
            String opcja = kod.nextLine();
            if (opcja.equals("n")) {
                System.out.println("Cena do zapłaty " + cenaKoncowa);
                break;
            }
        }
        }



    }
