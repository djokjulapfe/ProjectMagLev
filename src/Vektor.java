/**
 * Created by djokjula on 18.3.16..
 */
class Vektor { //Vektor, because processing uses floats
    double[] x;

    Vektor(int n) {
        x = new double[n];
    }

    Vektor(double... a) {
        x = a.clone();
    }

    private double dot(Vektor B) {
        double ret = 0;
        for (int i = 0; i < x.length; i++) {
            ret += x[i] * B.x[i];
        }
        return ret;
    }

    static double dot(Vektor A, Vektor B) {
        Vektor C = A.clone();
        return C.dot(B);
    }

    void sub(Vektor B) {
        for (int i = 0; i < x.length; i++) {
            x[i] -= B.x[i];
        }
    }

    static Vektor sub(Vektor A, Vektor B) {
        Vektor C = A.clone();
        C.sub(B);
        return C;
    }

    void add(Vektor B) {
        for (int i = 0; i < x.length; i++) {
            x[i] -= B.x[i];
        }
    }

    static Vektor add(Vektor A, Vektor B) {
        Vektor C = A.clone();
        C.add(B);
        return C;
    }

    void mult(double a) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= a;
        }
    }

    static Vektor mult(Vektor A, double a) {
        Vektor C = A.clone();
        C.mult(a);
        return C;
    }

    double mag() {
        double sum = 0;
        for (double aX : x) {
            sum += aX * aX;
        }
        return Math.sqrt(sum);
    }

    void setMag(double l) {
        double sum = this.mag();
        this.mult(l/sum);
    }

    public Vektor clone() {
        Vektor ret = new Vektor();
        ret.x = x.clone();
        return ret;
    }

    private static Vektor fromAngle(double a, double b) {
        double[] val = new double[3];
        val[0] = Math.cos(b)*Math.cos(a);
        val[1] = Math.cos(b)*Math.sin(a);
        val[2] = Math.sin(b);
        return new Vektor(val[0], val[1], val[2]);
    }

    //Simulation Spesific

    private void h2toh3() { //Turns a 2-D angle vector to 3-D direction vector
        x = Vektor.fromAngle(x[0], x[1]).x;
    }

    static Vektor h2toh3(Vektor r) {
        Vektor ret = r.clone();
        ret.h2toh3();
        return ret;
    }
}
