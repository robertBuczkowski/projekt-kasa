import java.io.Serializable;

class Produkt implements Serializable {

    private float cena;
    private float waga;
    private int kodKreskowy;
    private String nazwa;

    public Produkt(String nazwa, float cena, float waga, int kodKreskowy) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.waga = waga;
        this.kodKreskowy = kodKreskowy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        if(cena < 0)
            System.out.println("Podaj poprawną cenę");
        else
        this.cena = cena;
    }

    public float getWaga() {
        return waga;
    }

    public void setWaga(float waga) {
        if (waga < 0)
            System.out.println("Podaj poprawną wagę");
        else
        this.waga = waga;

    }

    public int getKodKreskowy() {
        return kodKreskowy;
    }

    public void setKodKreskowy(int kodKreskowy) {
        this.kodKreskowy = kodKreskowy;
    }
}
