/**
 * Created by djokjula on 18.3.16..
 */
public class Powell extends Optimisation { // Powell's Method ... under debugging
    private Vektor[] N;

    Powell(Model M) {
        super(M);
        best = new Vektor(M.dim);
        N = new Vektor[M.dim*2];
        double step = 1.0e-1;
        for (int i = 0; i < M.dim; i++) {
            N[2*i] = new Vektor(M.dim);
            N[2*i].x[i] = step;
            N[2*i+1] = new Vektor(M.dim);
            N[2*i+1].x[i] = -step;
        }
    }

    @Override
    public void update() {
        double[] values = new double[best.x.length*2];
        int mini = 0;
        double min = 1e308;
        for (int i = 0; i < values.length; i++) {
            values[i] = M.getFitness(Vektor.add(N[i], best));
            if(values[i] < min) {
                min = values[i];
                mini = i;
            }
        }
        best.add(N[mini].clone());
    }
}
