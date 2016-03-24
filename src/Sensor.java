import java.util.Arrays;

/**
 * Created by djokjula on 15.3.16..
 */
public class Sensor {

    private Vektor P; // Position of the sensor (every has the same orientation)

    public Sensor(Vektor P) {
        this.P = P;
    }

    public Vektor measure(Magnet M) { // Returns the value a sensor would give if it were measuring it.
        Vektor Pm = Vektor.sub(this.P, M.getP());
        double R = Vektor.sub(Pm, M.getP()).mag();
        Vektor B = Vektor.mult(Pm, (float) (Vektor.dot(M.getH(), Pm) * 3 / Math.pow(R, 5)));
        B.sub(Vektor.mult(M.getH(), (float) (1 / Math.pow(R, 3))));
        B.mult((float) M.getNT());
        return B;
    }

    public Vektor getP() {
        return P;
    }

    public void setP(float x, float y, float z) {
        P = new Vektor(x, y, z);
    }
}
