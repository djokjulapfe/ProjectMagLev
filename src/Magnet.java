/**
 * Created by djokjula on 15.3.16..
 */
public class Magnet {

    private double NT; // N_T from the equation
    private Vektor P; // Position
    private Vektor H; // Rotation Vector

    public Magnet() {
        P = new Vektor(0, 0, 0);
        H = new Vektor(1, 0, 0);
        NT = 1;
    }

    public Vektor getP() {
        return P;
    }

    public void setP(Vektor p) {
        P = p;
    }

    public void setP(double x, double y, double z) {
        P = new Vektor(x, y, z);
    }

    public Vektor getH() {
        return H;
    }

    public void setH(Vektor h) {
        H = h;
    }

    public void setH(double x, double y, double z) {
        H = new Vektor(x, y, z);
        H.setMag(1);
    }

    public double getNT() {
        return NT;
    }
}
