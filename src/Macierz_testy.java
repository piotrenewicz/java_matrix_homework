import javax.crypto.Mac;

public class Macierz_testy {

    public static void main(String []args){
        // piotrek

        Macierz m = new Macierz();
       // System.out.println(m);

        Macierz dot_product_A = new Macierz(
                1,2,3,
                4,5,6,
                0,0,0
        );

        Macierz dot_product_B = new Macierz(
                7, 8, 0,
                9, 10,0,
                11,12,0
        );

        Macierz result = dot_product_A.matrix_multiply(dot_product_B);
        System.out.println(result);

        // tomek

        System.out.println("Dodawanie macierzy m1 oraz m2:");
        Macierz m1, m2;
        m1 = new Macierz(1,2,3,4,5,6,7,8,9);
        m2 = new Macierz(9,8,7,6,5,4,3,2,1);
        System.out.println("m1:");
        System.out.println(m1);
        System.out.println("m2:");
        System.out.println(m2);
        m1.dodawanie(m2);
        System.out.println("Wynik dodawania:");
        System.out.println(m1);

        System.out.println("Odejmowanie macierzy m1 oraz m2:");
        System.out.println("m1:");
        System.out.println(m1);
        System.out.println("m2:");
        System.out.println(m2);
        m1.element_subtract(m2);
        System.out.println("Wynik odejmowania:");
        System.out.println(m1);

        // konrad

        double[][] d = {{1, 3, 4}, {2,4,3}, {3, 4, 5}};
        Macierz matrix = new Macierz(d);

        System.out.println(matrix); //matrix.transpose();
        System.out.println(matrix.determinant());



    }
}
