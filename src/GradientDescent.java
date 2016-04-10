import java.util.Arrays;

/**
 * Created by djokjula on 20.3.16..
 */
class GradientDescent extends Optimisation { // Gradient descent ... under debugging
    private Vektor[] N;

    GradientDescent(Model M) {
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
            newBest.add(Vektor.mult(N[i], 1e-3*(values[i] - fitness)/step/step));
        }
        best.add(newBest);
        fitness = M.getFitness(best);
    }
}
