import processing.core.PApplet;

import javax.jws.WebParam;
import java.util.Arrays;

/**
 * Created by djokjula on 15.3.16..
 */
public class Main {
    public static void main(String[] args) {
        Magnet Mag = new Magnet();
        Mag.setP(0, 0, 0.5);
        Mag.setH(1, 0, 0);
        Model M = new Model(Mag);
        M.setModelMatrix(new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 1}});
        Optimisation O = new GradientDescend(M);
        O.setBest(new Vektor(1, 1));
        for (int i = 0; i < 10; i++) {
            O.update();
            System.out.println(Arrays.toString(O.best.x));
        }
        System.out.println(Arrays.toString(O.best.x));
        //System.out.println(M.getFitness(O.best));

        //Main display
        PApplet.runSketch(new String[]{"A"}, new Drawer());
    }

    public static class Drawer extends PApplet {

        Magnet M = new Magnet();
        Sensor S = new Sensor(new Vektor(0, 0, -1));

        @Override
        public void settings() {
            size(500, 500);
        }

        @Override
        public void setup() { // Sets the position of the magnet
            M.setP(0, 0, 0.1);
            M.setH(0, -1, 0);
        }

        @Override
        public void draw() {
            background(255);
            for (float x = -1; x <= 1; x += 0.1) {
                for (float y = -1; y <= 1; y += 0.1) {
                    S.setP(x, y, 0); // loops through all of sensor positions need for visualisation
                    Vektor B = S.measure(M);
                    B.setMag(1e2f); // Comment this line to get only directions (not the magnitudes)
                    pushMatrix();
                    translate(width / 2, -height / 2);
                    ellipse(x * width / 2, height - y * height / 2, 5, 5);
                    line(x * width / 2, height - y * height / 2, (float) (x * width / 2 + B.x[0] * 2.0e-1f), (float) (height - y * height / 2 - B.x[1] * 2.0e-1f));
                    popMatrix();
                }
            }
            save("magpolje.png");
            exit();
        }
    }
}
