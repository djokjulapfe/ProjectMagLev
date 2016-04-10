import javax.jws.WebParam;

/**
 * Created by djokjula on 15.3.16..
 */
class Model {

    int dim; //Number of arguments for the optimisation

    Model(Object... objects) {
        dim = 2;
    }

    public void setModelMatrix(int[][] matrix) {

    }

    public double getFitness(Vektor vec) { // Default fitness
        double ret = -Math.exp(-vec.x[0]*vec.x[0]-(vec.x[1]-0.5)*(vec.x[1]-0.5));
        return ret;
    }
}
