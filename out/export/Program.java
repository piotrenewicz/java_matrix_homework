import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Dimension;
class Prostokat extends Rectangle
{
    Prostokat(int a,int b)
    {
        //konrad
        //konstruktory nadklasy sa dziedziczone
        //slowo super odwoluje sie bezposrednio do klasy rodzica.
        //super() uzywa sie do wywolywania nadpisanych metod rodzica w klasie 
        //potomka
        super(a,b);
    }

    //piotrek
    Prostokat(Point wierzcholek, int szer, int dlug){
        super(wierzcholek, new Dimension(szer, dlug));
    }

    boolean Przylega(Prostokat other){
        if (this.intersects(other)){
            Dimension overlap = this.intersection(other).getSize();
            return overlap.height * overlap.width == 0;
        }
        return false;
    }

    void info()
    {
        System.out.println(this);
    }
}

public class Program
{
    public static void main(String[] args)
    {

        Prostokat a=new Prostokat(3,4);
        a.info();

        Prostokat b=new Prostokat(2,2);
        b.info();

        if(a.intersects(b))
        {
            System.out.println("-- przecinaja sie --\n");
        }
        else
        {
            System.out.println("-- NIE przecinaja sie --\n");
        }



        a.translate(5,3);
        a.info();

        if(a.intersects(b))
        {
            System.out.println("-- przecinaja sie --\n");
        }
        else
        {
            System.out.println("-- NIE przecinaja sie --\n");
        }

    }
}