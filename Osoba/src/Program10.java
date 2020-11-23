import java.io.*;
class Osoba
{
    String imie;
    String nazwisko;
    int rokUrodzenia;

    Osoba(String imie,String nazwisko,int rokUrodzenia)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.rokUrodzenia=rokUrodzenia;
    }

    public String toString()
    {
        return this.imie+" "+this.nazwisko+" "+this.rokUrodzenia;
    }
}

interface Przeszukiwalne
{
    boolean czyPasuje(String wzorzec);
}

abstract class Dokument implements Przeszukiwalne
{

}

class Paszport extends Dokument
{
    Osoba wlasciciel;
    String typ;
    public boolean czyPasuje(String wzorzec)
    {
        return wzorzec.equalsIgnoreCase(this.wlasciciel.nazwisko);
    }
    public Paszport(Osoba w) {
        this.typ = "Paszport";
        this.wlasciciel = w;
    }

    public String toString()
    {
        return this.typ +" "+ this.wlasciciel.toString();
    }
}

class DowodOsobisty extends Dokument
{
    Osoba wlasciciel;
    String typ;
    public boolean czyPasuje(String wzorzec)
    {
        return wzorzec.equalsIgnoreCase(this.wlasciciel.nazwisko);
    }
    public DowodOsobisty(Osoba w) {
        this.typ = "Dowod";
        this.wlasciciel = w;
    }

    public String toString()
    {
        return this.typ +" "+ this.wlasciciel.toString();
    }
}


public class Program10
{
    public static void main(String[] args)
    {
        Osoba W = new Osoba("Jan", "Kowalski", 1800);
        Osoba X = new Osoba("Edyta", "Gorniak", 1700);
        Osoba Y = new Osoba("Kamil", "Górny", 1234);

        Dokument[] bazaDanych={new Paszport(W),new DowodOsobisty(X),new Paszport(Y)};

        Dokument z;
        String wzorzec="Gorniak";

        for (Dokument danych : bazaDanych) {
            z = danych;
            if (z.czyPasuje(wzorzec)) System.out.println("znaleziono: " + z);
        }
    }
}
