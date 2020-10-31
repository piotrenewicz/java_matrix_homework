//Piotr Morel, Konrad Maciejczyk, Tomasz Tomżyński, Java, gr 2, 2020

public class Macierz {
    double[][] data = new double[3][3];

    Macierz(){ // konstruktor zerowy
        this(0);
    }

    Macierz(double intial){ // konstruktor jednolity
        for(int i = 0; i < 9; i++){
            this.data[i/3][i%3] = intial;
        }
    }

    Macierz(double[][] full_input){ // konstruktor całość na raz
        this.data = full_input;
    }

    Macierz(double[] row1, double[] row2, double[] row3){ // konstruktor linia po linii
        this.data[0] = row1;
        this.data[1] = row2;
        this.data[2] = row3;
    }

    Macierz(double a1, double a2, double a3, // konstruktor pełny, każdego elementu pojedyńczo
            double b1, double b2, double b3,
            double c1, double c2, double c3){
        this.data = new double[][]{
                {a1,a2,a3},
                {b1,b2,b3},
                {c1,c2,c3}
        };
    }

    public Macierz copy(){ // zwraca kopie obencej macierzy
        return new Macierz(
                this.data[0].clone(),
                this.data[1].clone(),
                this.data[2].clone()
        );
    }

    public void _scale(double scalar){ // mnoży wszystkie elementy macierzy przez skalar
        for(int i = 0; i < 9; i++){
            this.data[i/3][i%3] *= scalar;
        }
    }
    public void _shift(double difference){ // dodaje jeden skalar do wszystkich elementów macierzy
        for(int i = 0; i < 9; i++){
            this.data[i/3][i%3] += difference;
        }
    }

    public void _element_multiply(Macierz other){ // mnoży elementy dwóch macierzy, bezpośrednio nakładając je na siebie.
        for(int i = 0; i < 9; i++){
            this.data[i/3][i%3] *= other.data[i/3][i%3];
        }
    }

    public void _element_subtract(Macierz other){ // odejmuje elementy dwóch macierzy
        other = other.copy();
        other.scale(-1);
        this.dodawanie(other);
    }

    public Macierz matrix_multiply(Macierz other){ // wykonuję mnożenie macierzy metodą kross product
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

//    Metoda sumuje elementy dwóch macierzy o współrzędnych i, j
    public void _dodawanie(Macierz diff) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.data[i][j] += diff.data[i][j];
            }
        }
    }


    // konrad

    public void _transpose(){ //transpozycja macierzy
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

    // piotrek (przerzutki które nie niszczą obecnej macierzy)
    public Macierz scale(double scalar){
        Macierz copy = this.copy();
        copy._scale(scalar);
        return copy;
    }

    public Macierz shift(double difference){
        Macierz copy = this.copy();
        copy._shift(difference);
        return copy;
    }

    public Macierz element_multiply(Macierz other){ // mnoży elementy dwóch macierzy, bezpośrednio nakładając je na siebie.
        Macierz copy = this.copy();
        copy._element_multiply(other);
        return copy;
    }

    public Macierz element_subtract(Macierz other){ // odejmuje elementy dwóch macierzy
        Macierz copy = this.copy();
        copy._element_subtract(other);
        return copy;
    }

    //    Metoda sumuje elementy dwóch macierzy o współrzędnych i, j
    public Macierz dodawanie(Macierz diff) {
        Macierz copy = this.copy();
        copy._dodawanie(diff);
        return copy;
    }

    public Macierz transpose(){ //transpozycja macierzy
        Macierz copy = this.copy();
        copy._transpose();
        return copy;
    }

}
