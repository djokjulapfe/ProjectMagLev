/**
 * Created by djokjula on 15.3.16..
 */
public class Optimisation {
    Model M;
    Vektor best; // Current best vector found (needed for some optimisation algorithms)
    double fitness; // fitness(best)

    Optimisation(Model M) {
        this.M = M;
    }

    public void update() {

    }

    public void setBest(Vektor best) {
        this.best = best;
        fitness = M.getFitness(best);
    }
}
