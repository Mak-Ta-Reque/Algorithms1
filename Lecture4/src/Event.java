import edu.princeton.cs.algs4.Particle;

public class Event implements Comparable<Event> {
    public double time;
    public Particle a, b;
    private int countA, countB;
    public Event(double t, Particle a, Particle b) {
        this.time = t;
        this.a    = a;
        this.b    = b;
        if (a != null) countA = a.count();
        else           countA = -1;
        if (b != null) countB = b.count();
        else           countB = -1;
    }
    public int compareTo(Event that) {
        return Double.compare(this.time, that.time);  
    }
    public boolean isValid() {
        if (a != null && a.count() != countA) return false;
        if (b != null && b.count() != countB) return false;
        return true;
    }
    
}
