/**
 * Created by djokjula on 15.3.16..
 */
class Magnet {

    private double NT; // N_T from the equation
    private Vektor P; // Position
    private Vektor H; // Rotation Vector

    Magnet() {
        P = new Vektor(0, 0, 0);
        H = new Vektor(1, 0, 0);
        NT = 1;
    }

    Vektor getP() {
        return P;
    }

    void setP(Vektor p) {
        P = p;
    }

    void setP(double x, double y, double z) {
        P = new Vektor(x, y, z);
    }

    Vektor getH() {
        return H;
    }

    void setH(Vektor h) {
        H = h;
    }

    void setH(double x, double y, double z) {
        H = new Vektor(x, y, z);
        H.setMag(1);
    }

    double getNT() {
        return NT;
    }
}
