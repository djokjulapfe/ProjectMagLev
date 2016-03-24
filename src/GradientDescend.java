import java.util.Arrays;

/**
 * Created by djokjula on 20.3.16..
 */
public class GradientDescend extends Optimisation { // Gradient descent ... under debugging
    double step;
    private Vektor[] N;

    GradientDescend(Model M) {
        super(M);
        N = new Vektor[M.dim];
        step = 1.0e-4;
        for (int i = 0; i < M.dim; i++) {
            N[i] = new Vektor(M.dim);
            N[i].x[i] = step;
        }
    }

    @Override
    public void update() { // Next iteration
        Vektor newBest = new Vektor(best.x.length);
        double[] values = new double[best.x.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = M.getFitness(Vektor.add(best, N[i]));
            newBest.add(Vektor.mult(N[i], -1e4*(fitness - values[i]) / step));
        }
        //setBest(Vektor.add(best, newBest));
        Vektor vs = new Vektor(values.length);
        for (int i = 0; i < values.length; i++) {
            vs.x[i] = -fitness + values[i];
        }
        best.add(newBest);
        fitness = M.getFitness(best);
        /*
        System.out.println(fitness);
        System.out.println(Arrays.toString(newBest.x));
        System.out.println(Arrays.toString(vs.x));
        System.out.println(Arrays.toString(best.x));
        /**/
    }
}
