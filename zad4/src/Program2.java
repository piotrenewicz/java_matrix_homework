abstract class Figura //nie mozna tworzyc instancji tej klasy 
{
    abstract double pole(); //metoda abstrakcyjna
    abstract double obwod();

    void info()
    {
        System.out.println(this);
    }
}
class Okrag extends Figura
{
    double promien;

    Okrag(double promien)
    {
        this.promien=promien;
    }

    double pole()
    {
        return 3.14*promien*promien;
    }

    double obwod()
    {
        return 2*3.14*promien;
    }

    public String toString()
    {
        return "okrag o pr. "+promien;
    }
}
class Prostokat2 extends Figura
{
    double dlugosc;
    double szerokosc;

    Prostokat2(double dlugosc,double szerokosc)
    {
        this.dlugosc=dlugosc;
        this.szerokosc=szerokosc;
    }

    double pole()
    {
        return dlugosc*szerokosc;
    }

    double obwod()
    {
        return 2*dlugosc+2*szerokosc;
    }

    public String toString()
    {
        return "prostokat o wym. "+dlugosc+" na "+szerokosc;
    }
}
// piotrek
class Kwadrat extends Prostokat2
{
    double bok;
    Kwadrat(double bok){
        super(bok, bok);
        this.bok = bok;
    }

    public String toString(){
        return "kwadrat o boku "+bok;
    }
}


//tomek




//konrad



public class Program2
{
    public static void main(String[] args)
    {
        Figura z=new Okrag(2);
        z.info();

        Figura[] a={new Prostokat2(3,5),new Okrag(8),new Okrag(3)};

        Figura x;
        double suma=0;

        for (Figura figura : a) {
            x = figura;
            x.info();
            suma = suma + x.pole();
        }

        System.out.println("suma pol figur: "+suma);
    }
}