/**
 * Created by djokjula on 18.3.16..
 */
public class Vektor { //Vektor, because processing uses floats
    double[] x;

    public Vektor(int n) {
        x = new double[n];
    }

    public Vektor(double... a) {
        x = a.clone();
    }

    public double dot(Vektor B) {
        double ret = 0;
        for (int i = 0; i < x.length; i++) {
            ret += x[i] * B.x[i];
        }
        return ret;
    }

    public static double dot(Vektor A, Vektor B) {
        Vektor C = A.clone();
        return C.dot(B);
    }

    public void sub(Vektor B) {
        for (int i = 0; i < x.length; i++) {
            x[i] -= B.x[i];
        }
    }

    public static Vektor sub(Vektor A, Vektor B) {
        Vektor C = A.clone();
        C.sub(B);
        return C;
    }

    public void add(Vektor B) {
        for (int i = 0; i < x.length; i++) {
            x[i] -= B.x[i];
        }
    }

    public static Vektor add(Vektor A, Vektor B) {
        Vektor C = A.clone();
        C.add(B);
        return C;
    }

    public void mult(double a) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= a;
        }
    }

    public static Vektor mult(Vektor A, double a) {
        Vektor C = A.clone();
        C.mult(a);
        return C;
    }

    public double mag() {
        double sum = 0;
        for (double aX : x) {
            sum += aX * aX;
        }
        return Math.sqrt(sum);
    }

    public void setMag(double l) {
        double sum = this.mag();
        this.mult(l/sum);
    }

    public Vektor clone() {
        Vektor ret = new Vektor();
        ret.x = x.clone();
        return ret;
    }

    public static Vektor fromAngle(double a, double b) {
        double[] val = new double[3];
        val[0] = Math.cos(b)*Math.cos(a);
        val[1] = Math.cos(b)*Math.sin(a);
        val[2] = Math.sin(b);
        return new Vektor(val[0], val[1], val[2]);
    }

    //Simulation Spesific

    public void h2toh3() { //Turns a 2-D angle vector to 3-D direction vector
        x = Vektor.fromAngle(x[0], x[1]).x;
    }

    public static Vektor h2toh3(Vektor r) {
        Vektor ret = r.clone();
        ret.h2toh3();
        return ret;
    }
}
