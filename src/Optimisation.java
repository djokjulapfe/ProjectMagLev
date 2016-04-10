/**
 * Created by djokjula on 15.3.16..
 */
class Optimisation {
    Model M;
    Vektor best; // Current best vector found (needed for some optimisation algorithms)
    double fitness; // fitness(best)
    double step;

    Optimisation(Model M) {
        this.M = M;
        step = 1e-3;
    }

    public void update() {

    }

    void setBest(Vektor best) {
        this.best = best;
        fitness = M.getFitness(best);
    }
}
