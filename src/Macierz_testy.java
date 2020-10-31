public class Macierz_testy {

    public static void main(String []args){
        // piotrek

        Macierz m = new Macierz();
       // System.out.println(m);

        // tomek



        // konrad

        double d[][] = {{1, 3, 4}, {2,4,3}, {3, 4, 5}}; 
        Macierz matrix = new Macierz(d);

        System.out.println(matrix); //matrix.transpose();
        System.out.println(matrix.determinant());



    }
}
