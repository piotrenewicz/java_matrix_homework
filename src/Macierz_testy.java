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



        // konrad

        double d[][] = {{1, 3, 4}, {2,4,3}, {3, 4, 5}}; 
        Macierz matrix = new Macierz(d);

        System.out.println(matrix); //matrix.transpose();
        System.out.println(matrix.determinant());



    }
}
