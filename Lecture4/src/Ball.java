import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ball {
    private double rx, ry; // position
    private double vx, vy; // velocity
    private final double radious; // radious of ball
    public Ball() {
        this.radious = 0.01;
        rx = StdRandom.uniform();
        ry = StdRandom.uniform();
        vx = StdRandom.uniform();
        vy = StdRandom.uniform();
        
    }
    
    public void move(double dt) {
        if ((rx + vx*dt < radious) || (rx + vx*dt > 1.0 - radious)) vx = - vx;
        if ((ry + vx*dt < radious) || (ry +vy*dt > 1.0 - radious)) vy = -vy;
        rx = rx + vx*dt;
        ry = ry + vy*dt;
    }
    
    public void draw() {
        StdDraw.filledCircle(rx, ry, radious);
    }
    
}
