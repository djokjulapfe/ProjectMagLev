import javax.jws.WebParam;

/**
 * Created by djokjula on 15.3.16..
 */
public class Model {

    int dim; //Number of arguments for the optimisation

    public Model(Object ... objects) {
        dim = 2;
    }

    public void setModelMatrix(int[][] matrix) {

    }

    public double getFitness(Vektor vec) { // Default fitness
        return vec.mag();
    }
}
