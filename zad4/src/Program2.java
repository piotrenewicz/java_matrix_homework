//import org.graalvm.compiler.core.common.alloc.Trace;

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
class Trapez extends  Figura
//    trapez prostokatny
{
    double wysokosc;
    double podstawa1;
    double podstawa2;

    Trapez(double wysokosc, double podstawa1, double podstawa2)
    {
        this.wysokosc = wysokosc;
        this.podstawa1 = podstawa1;
        this.podstawa2 = podstawa2;
    }
    double pole()
    {
        return ((podstawa1 + podstawa2) * wysokosc)/2;
    }

    double obwod()
    {
        double b = (podstawa2 - podstawa1) * (podstawa2 - podstawa1);
        b += wysokosc * wysokosc;
        b = Math.sqrt(b);
        return wysokosc + podstawa1 + podstawa2 + b;
    }

    public String toString()
    {
        return "trapez o podstawach "+podstawa1+", "+podstawa2+" i wysokosci "+wysokosc;
    }
}



//konrad
class Trojkat extends Figura{
    double x1, y1, x2, y2, x3, y3;
    double a, b, c;

    Trojkat(double x1, double y1, double x2, double y2, double x3, double y3){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;

        this.a = distance(x1, y1, x2, y2);
        this.b = distance(x2, y2, x3, y3);
        this.c = distance(x1, y1, x3, y3);
    }

    double distance(double x1, double y1, double x2, double y2){
        double d = Math.pow((x2 - x1),2) + Math.pow((y1 - y2), 2);
        d = Math.sqrt(d);

        return d;
    }

    double obwod(){
        return this.a + this.b + this.c;
    }

    boolean is_possible(){//nierownosc trojkata
        return (this.a + this.b > this.c) && (this.b + this.c > this.a) && (this.c + this.a > this.b);
    }

    double pole(){
        if (is_possible()){
            return (Math.sqrt(a + b + c)*(a + b - c)*(a - b + c)*(-a + b + c)) / 4;
        }else{
            return -1;
        }
    }

    public String toString(){
        return "Trojkat(" + this.a + ", " + this.b + ", " + this.c +")";
    }

}


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

        Trojkat triangle = new Trojkat(0, 0, 0, 20, 29, 0);
        System.out.println(triangle);
        Figura t=new Trapez(6, 2, 4);
        t.info();
        System.out.println("Pole trapezu " + t.pole());
        System.out.println("Obwod trapezu " + t.obwod());
    }
}