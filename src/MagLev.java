import java.util.Objects;

/**
 * Created by djokjula on 21.3.16..
 */
public class MagLev extends Model {


    private Magnet M;
    private Sensor[] S; // Array of sensors
    private Vektor[] real; // Values that the sensors would give

    MagLev(Magnet M) {
        this.M = M;
        dim = 5;
    }

    public void setModelMatrix(int[][] matrix) { //Sets the number and positions of the sensors.
        int n = 0;
        for (int[] array : matrix) for (int elem : array) n += elem;
        S = new Sensor[n];
        real = new Vektor[n];
        int k = 0;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (matrix[i][j] == 1) S[k++] = new Sensor(new Vektor(j * 0.1f - 0.35f, i * 0.1f - 0.35f, 0));
        for (int i = 0; i < S.length; i++) {
            real[i] = S[i].measure(M);
        }
    }

    public double getFitness(Vektor vec) { // Returns the fitness for the optimisation. The sum of sensor errors.
        Magnet Mag = new Magnet();
        Mag.setP(new Vektor(vec.x[0], vec.x[1], vec.x[2]));
        Mag.setH(Vektor.h2toh3(new Vektor(vec.x[3], vec.x[4])));
        Vektor sum = new Vektor(3);
        for (int i = 0; i < S.length; i++) {
            sum.add(Vektor.sub(real[i], S[i].measure(Mag)));
        }
        return sum.mag();
    }
}
