public class Macierz {
    double[][] data = new double[3][3];

    Macierz(double[][] full_input){
        this.data = full_input;
    }

    Macierz(double[] row1, double[] row2, double[] row3){
        this.data[0] = row1;
        this.data[1] = row2;
        this.data[2] = row3;
    }

    Macierz(double a1, double a2, double a3,
            double b1, double b2, double b3,
            double c1, double c2, double c3){
        this.data = new double[][]{
                {a1,a2,a3},
                {b1,b2,b3},
                {c1,c2,c3}
        };
    }

    public Macierz copy(){
        return new Macierz(this.data);
    }

    public void scale(double scalar){
        for(int i = 0; i < 9; i++){
            this.data[i/3][i%3] *= scalar;
        }
    }
    public void shift(double difference){
        for(int i = 0; i < 9; i++){
            this.data[i/3][i%3] += difference;
        }
    }

    public void element_multiply(Macierz other){
        for(int i = 0; i < 9; i++){
            this.data[i/3][i%3] *= other.data[i/3][i%3];
        }
    }



    // tomek




    // konrad

    public void transpose(){
        double[][] aux = new double[3][3];

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                aux[i][j] = this.data[j][i];
            }
        }

        data = aux;
    }

}
