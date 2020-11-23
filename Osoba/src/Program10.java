import java.io.*;
class Osoba implements Serializable
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
    public boolean czyPasuje(String wzorzec)
    {
        return false;
    }

    public String toString()
    {
        return "";
    }
}
class DowodOsobisty extends Dokument
{
    public boolean czyPasuje(String wzorzec)
    {
        return false;
    }

    public String toString()
    {
        return "";
    }
}


public class Program10
{
    public static void main(String[] args)
    {
        Dokument[] bazaDanych={new Paszport(),new DowodOsobisty(),new Paszport()};

        Dokument z;
        String wzorzec="Gorniak";

        for(int i=0;i<bazaDanych.length;i++)
        {
            z=bazaDanych[i];
            if(z.czyPasuje(wzorzec))System.out.println("znaleziono: "+z);
        }
    }
}
