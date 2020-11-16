//Piotr Morel, Konrad Maciejczyk, Tomasz Tomżyński, Java, gr 2, 2020


public class Macierz_testy {

    public static void main(String []args){
        // piotrek

        System.out.println("Testy metod zawartych w klasie macierz");
        System.out.println("--------------------------------------------");

        System.out.println("Tworzenie macierzy wypełnionej zerami");
        Macierz m = new Macierz();
        System.out.println(m);
        System.out.println("--------------------------------------------");

        System.out.println("Iloczyn wektorowy macierzy A i B");
        System.out.println("Macierz A:");
        Macierz dot_product_A = new Macierz(
                1,2,3,
                4,5,6,
                0,0,0
        );
        System.out.println(dot_product_A);

        System.out.println("Macierz B:");
        Macierz dot_product_B = new Macierz(
                7, 8, 0,
                9, 10,0,
                11,12,0
        );
        System.out.println(dot_product_B);

        System.out.println("Wynik iloczynu wektorowego");
        Macierz result = dot_product_A.matrix_multiply(dot_product_B);
        System.out.println(result);
        System.out.println("--------------------------------------------");

        // tomek

        System.out.println("Test kopiowania macierzy");
        Macierz copy_test_base = new Macierz(1);
        System.out.println("Macierz bazowa");
        System.out.println(copy_test_base);
        Macierz copy_test_copied = copy_test_base.copy();
        System.out.println("Kopia macierzy:");
        System.out.println(copy_test_copied);
        copy_test_base._scale(-1);
        System.out.println("Zmiana w macierzy bazowej:");
        System.out.println(copy_test_base);
        System.out.println("Kopia macierzy bazowej");
        System.out.println(copy_test_copied);
        System.out.println("--------------------------------------------");

        System.out.println("Mnożenie macierzy przez skalar");
        Macierz scale_A = new Macierz(1,1,1,2,2,2,3,3,3);
        System.out.println("Macierz:");
        System.out.println(scale_A);
        scale_A._scale(2); //przykład użycia starej funkcji
        System.out.println("Macierz pomnożona przez 2");
        System.out.println(scale_A);
        System.out.println("--------------------------------------------");

        System.out.println("Dodawanie jednego skalara do wszystkich elementów macierzy");
        Macierz shift_A = new Macierz(1,1,1,2,2,3,4,5,6);
        System.out.println("Macierz");
        System.out.println(shift_A);
        System.out.println("Dodanie skalara 2 do każdego elementu macierzy");
        System.out.println(shift_A.shift(2));
        System.out.println("--------------------------------------------");

        System.out.println("Mnożenie macierzy 'bezpośrednio'");
        Macierz element_multiply_A = new Macierz(3,3,3,2,2,2,1,1,1);
        Macierz element_multiply_B = new Macierz(3,2,1,1,2,3,3,2,1);
        System.out.println("Macierz A:");
        System.out.println(element_multiply_A);
        System.out.println("Macierz B:");
        System.out.println(element_multiply_B);
        System.out.println("Wynik mnożenia bezpośredniego macierzy A przez B:");
        System.out.println(element_multiply_A.element_multiply(element_multiply_B));
        System.out.println("--------------------------------------------");

        System.out.println("Dodawanie macierzy m1 oraz m2:");
        Macierz m1, m2;
        m1 = new Macierz(1,2,3,4,5,6,7,8,9);
        m2 = new Macierz(9,8,7,6,5,4,3,2,1);
        System.out.println("m1:");
        System.out.println(m1);
        System.out.println("m2:");
        System.out.println(m2);
        System.out.println("Wynik dodawania:");
        System.out.println(m1.dodawanie(m2));
        System.out.println("--------------------------------------------");

        System.out.println("Odejmowanie macierzy m1 oraz m2:");
        System.out.println("m1:");
        System.out.println(m1);
        System.out.println("m2:");
        System.out.println(m2);
        System.out.println("Wynik odejmowania:");
        System.out.println(m1.element_subtract(m2));
        System.out.println("--------------------------------------------");

        // konrad

        System.out.println("Transponowanie macierzy");
        double[][] d = {{1, 3, 4}, {2,4,3}, {3, 4, 5}};
        Macierz matrix = new Macierz(d);

        System.out.println("Macierz:"); System.out.println(matrix);
        System.out.println("Macierz transponowana:"); System.out.println(matrix.transpose());
        System.out.println("Wyznacznik macierzy: " + matrix.determinant());



    }
}
