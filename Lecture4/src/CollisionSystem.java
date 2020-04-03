import java.awt.Color;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class CollisionSystem {
    private static final double HZ = 0.5;
    private MinPQ<Event> pq;
    private double t = 0.0;
    private Particle[] particles;
    private int N; 
    public CollisionSystem(Particle[] particles) {
        this.particles = particles.clone();
        N = particles.length;
    }
    
    private void predict(Particle a, double limit) {
        if (a == null) return;

        // particle-particle collisions
        for (int i = 0; i < particles.length; i++) {
            double dt = a.timeToHit(particles[i]);
            if (t + dt <= limit)
                pq.insert(new Event(t + dt, a, particles[i]));
        }

        // particle-wall collisions
        double dtX = a.timeToHitVerticalWall();
        double dtY = a.timeToHitHorizontalWall();
        System.out.println(pq.size());
        if (t + dtX <= limit) pq.insert(new Event(t + dtX, a, null));
        if (t + dtY <= limit) pq.insert(new Event(t + dtY, null, a));
    }

    // redraw all particles
    private void redraw(double limit) {
        StdDraw.clear();
        for (int i = 0; i < particles.length; i++) {
            particles[i].draw();
        }
        StdDraw.show();
        StdDraw.pause(20);
        if (t < limit) {
            pq.insert(new Event(t + 1.0 / HZ, null, null));
        }
    }

      
    /**
     * Simulates the system of particles for the specified amount of time.
     *
     * @param  limit the amount of time
     */
    public void simulate(double limit) {
        
        // initialize PQ with collision events and redraw event
        pq = new MinPQ<Event>();
        for (int i = 0; i < particles.length; i++) {
            predict(particles[i], limit);
        }
        pq.insert(new Event(0, null, null));        // redraw event


        // the main event-driven simulation loop
        while (!pq.isEmpty()) { 

            // get impending event, discard if invalidated
            Event e = pq.delMin();
            if (!e.isValid()) continue;
            Particle a = e.a;
            Particle b = e.b;

            // physical collision, so update positions, and then simulation clock
            for (int i = 0; i < particles.length; i++)
                particles[i].move(e.time - t);
            t = e.time;

            // process event
            if      (a != null && b != null) a.bounceOff(b);              // particle-particle collision
            else if (a != null && b == null) a.bounceOffVerticalWall();   // particle-wall collision
            else if (a == null && b != null) b.bounceOffHorizontalWall(); // particle-wall collision
            else if (a == null && b == null) redraw(limit);               // redraw event

            // update the priority queue with new collisions involving a or b
            predict(a, limit);
            predict(b, limit);
        
            
            
            
        }
    }
        public static void main(String[] args) {

            StdDraw.setCanvasSize(600, 600);

            // enable double buffering
            StdDraw.enableDoubleBuffering();

            // the array of particles
            Particle[] particles;

            // create n random particles
            if (args.length == 1) {
                int n = Integer.parseInt(args[0]);
                particles = new Particle[n];
                for (int i = 0; i < n; i++)
                    particles[i] = new Particle();
            }

            // or read from standard input
            else {
                int n = StdIn.readInt();
                particles = new Particle[n];
                for (int i = 0; i < n; i++) {
                    double rx     = StdIn.readDouble();
                    double ry     = StdIn.readDouble();
                    double vx     = StdIn.readDouble();
                    double vy     = StdIn.readDouble();
                    double radius = StdIn.readDouble();
                    double mass   = StdIn.readDouble();
                    int r         = StdIn.readInt();
                    int g         = StdIn.readInt();
                    int b         = StdIn.readInt();
                    Color color   = new Color(r, g, b);
                    particles[i] = new Particle(rx, ry, vx, vy, radius, mass, color);
                }
            }

            // create collision system and simulate
            CollisionSystem system = new CollisionSystem(particles);
            system.simulate(10000);
        }
}
