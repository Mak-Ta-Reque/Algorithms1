package contactsim;

import java.awt.Color;

import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdDraw;

/**
 * The {@code People} class represent a person moving in unit box with given position, velocity,
 * radius, infection, and contacts
 * 
 * 
 * 
 * @author mak
 *
 */
public class People {
    private static final double INFINITY = Double.POSITIVE_INFINITY;
    
    private double rx, ry; // Position of a person 
    private double vx, vy;
    private final double radius;
    private int contacts;
    private Color color;
    private final double localArea; // radious Area where a person travel.
    private int count;
    /**
     * Initializes a person with the specified position, velocity, radius, mass, and color.
     * @param rx <em> x </em>-coordinate of position
     * @param ry <em> y </em>-coordinate of position
     * @param vx <em> x </em>-coordinate of velocity
     * @param vy <em> y </em>-coordinate of velocity
     * @param contacts <em> contact </em>-contacted with other people
     * @param color <em> infection </em>- red means infected
     * @param localArea <em> r </em> radius of area where a person normally travel
     */
    public People(double rx, double ry, double vx, double vy, int contacts, Color color, double localArea) {
        this.radius = 0;
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
        this.contacts = contacts;
        this.color = color;
        this.localArea = localArea;
        
    }
    
    public void move(double dt) {
        rx += vx*dt;
        ry += vy*dt;
    }
    
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(rx, ry, radius);
    }
    
    public int countContact() {
        return contacts;
    }
    public int count() {
        return count;
    }
    
    public double timeToHit(People that) {
        if (this == that) return INFINITY;
        double dx  = that.rx - this.rx;
        double dy  = that.ry - this.ry;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvdr = dx*dvx + dy*dvy;
        if (dvdr > 0) return INFINITY;
        double dvdv = dvx*dvx + dvy*dvy;
        if (dvdv == 0) return INFINITY;
        double drdr = dx*dx + dy*dy;
        double sigma = this.radius + that.radius;
        double d = (dvdr*dvdr) - dvdv * (drdr - sigma*sigma);
        // if (drdr < sigma*sigma) StdOut.println("overlapping particles");
        if (d < 0) return INFINITY;
        return -(dvdr + Math.sqrt(d)) / dvdv;
    }
    
    public double timeToHitVerticalWall() {
        if      (vx > 0) return (1.0 - rx - radius) / vx;
        else if (vx < 0) return (radius - rx) / vx;  
        else             return INFINITY;
    }

    /**
     * Returns the amount of time for this particle to collide with a horizontal
     * wall, assuming no interening collisions.
     *
     * @return the amount of time for this particle to collide with a horizontal wall,
     *         assuming no interening collisions; 
     *         {@code Double.POSITIVE_INFINITY} if the particle will not collide
     *         with a horizontal wall
     */
    public double timeToHitHorizontalWall() {
        if      (vy > 0) return (1.0 - ry - radius) / vy;
        else if (vy < 0) return (radius - ry) / vy;
        else             return INFINITY;
    }
    
    public void bounceOffVerticalWall() {
        vx = -vx;
        count++;
    }
    
    public void bounceOffHorizontalWall() {
        vy = -vy;
        count++;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
