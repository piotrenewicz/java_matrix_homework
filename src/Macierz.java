public class Macierz {
    double[][] data = new double[3][3];

    Macierz(){
        this(0);
    }

    Macierz(double intial){
        for(int i = 0; i < 9; i++){
            this.data[i/3][i%3] = intial;
        }
    }

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

    public void element_subtract(Macierz other){
        other = other.copy();
        other.scale(-1);
        this.dodawanie(other);
    }

    public Macierz matrix_multiply(Macierz other){
        Macierz result = new Macierz(0);
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                double element = 0;
                for(int z = 0; z < 3; z++){
                    element += this.data[x][z] * other.data[z][y];
                }
                result.data[x][y] = element;
            }
        }
        return result;
    }





    // tomek

    public void dodawanie(Macierz diff) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.data[i][j] += diff.data[i][j];
            }
        }
    }

    // konrad

    public void transpose(){ //transpozycja macierzy
        double[][] aux = new double[3][3];

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                aux[i][j] = this.data[j][i];
            }
        }

        data = aux;
    }

    public double determinant(){ //obliczanie wyznaczika macierzy
        double det = (this.data[0][0] * this.data[1][1] * this.data[2][2]) + (this.data[1][0] * this.data[2][1] * this.data[0][2]) + (this.data[2][0] * this.data[0][1] * this.data[1][2]) - (this.data[0][2] * this.data[1][1] * this.data[2][0] + this.data[1][2] * this.data[2][1] * this.data[0][0] + this.data[2][2] * this.data[0][1] * this.data[1][0]);

        return det;
    }

    public String toString(){ //metoda reprezentacyjna obiekt macierzy jako napis (typ string)
        StringBuilder napis = new StringBuilder("[");

        for(int i=0; i < 3; i++){
            napis.append("[");
            for(int j = 0; j < 3; j++){
                napis.append(this.data[i][j]).append(", ");
            }
            napis.insert(napis.length()-2,"]");
            napis.insert(napis.length()-1, "\n");
        }

        napis.insert(napis.length()-3, "]");
        napis.deleteCharAt(napis.length()-3);
        return napis.toString();
    }

}
