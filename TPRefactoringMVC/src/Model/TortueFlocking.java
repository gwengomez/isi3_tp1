/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Erwan
 */
public class TortueFlocking extends TortueAutonome {

    public static int distanceMin = Tortue.rp * 4; //minimal distance between tortue
    public static int visionRange = Tortue.rp * 8;
    public static int visionRadius = 70; //radius (+/- deg) which a turtle can see (between -visionRadius and +visionRadius - giving it a total radius of 2*visionRadius)

    public static ArrayList<Tortue> tortues;

    public TortueFlocking(int x, int y, int dir, int coul, Forme forme, int vitesse) {
        super(x, y, dir, coul, forme, vitesse);
    }

    public TortueFlocking(Forme f, int vitesse, int dir) {
        super(f, vitesse, dir);
    }
    
    public TortueFlocking() {
        super();
    }

    @Override
    public void nextStep() {
        ArrayList<TortueAutonome> inVisionRange = new ArrayList<>();
        ArrayList<TortueAutonome> tooClose = new ArrayList<>();
        for (Tortue te : tortues) {
            TortueAutonome t = (TortueAutonome) te;
            if (t == this) {
                continue;
            }
            double distance = this.getDistance(new Point(t.x, t.y));
            if (distance <= visionRange) {
                inVisionRange.add(t);
            }
        }
        ArrayList<TortueAutonome> inRadiusRange = new ArrayList<>();
        for (TortueAutonome t : inVisionRange) {
            double vectorX = t.x - this.x;
            double vectorY = t.y - this.y;
            double distance = this.getDistance(new Point(t.x, t.y));

            //normalized vector between this Tortue and target one
            double normalizedVectorX = vectorX / distance;
            double normalizedVectorY = vectorY / distance;

            //normalized view vector (from vision range and vision radius)
            double pointX = visionRange * Math.cos(this.dir * (Math.PI / 180));
            double pointY = visionRange * Math.sin(this.dir * (Math.PI / 180));

            double norme = this.getDistance(pointX, pointY);

            //vector normalized
            double viewVectorX = (pointX - (double) this.x) / norme;
            double viewVectorY = (pointY - (double) this.y) / norme;

            double dotProduct = normalizedVectorX * viewVectorX + normalizedVectorY * viewVectorY;

            double angle = Math.acos(dotProduct);
            double degAngle = 180 * angle / Math.PI;
            if (degAngle <= visionRadius) {
                inRadiusRange.add(t);
                if (this.getDistance(new Point(t.x, t.y)) < distanceMin) {
                    tooClose.add(t);
                }
            }
        }
        //no other Tortue in sight 
        if (inRadiusRange.isEmpty()) {
            if (tooClose.size() != 0) {
                //we're too close from at least one Tortue
            }
            super.nextStep();
        } else {
            double moyVitesse = 0, moyDir = 0;
            for (TortueAutonome t : inRadiusRange) {
                moyVitesse += t.getVitesse();
                moyDir += t.getDir();
            }
            moyVitesse = moyVitesse / inRadiusRange.size();
            moyDir = moyDir / inRadiusRange.size();
            this.setVitesse((int) Math.round(moyVitesse));
            this.setDir((int) Math.round(moyDir));
            if (tooClose.isEmpty()) {
                this.avancer(this.getVitesse());
            } else {
                this.avancer(this.getVitesse() / 2);
            }
        }
    }

    /*private ArrayList<Point> getPointsPossibles(TortueFlocking t) {
     ArrayList<Point> pts = new ArrayList<>();
     Point pt = new Point(t.x, t.y);
     pts.add(pt);
     pts.add(translateRight(pt));
     pts.add(translateLeft(pt));
     pts.add(translateTop(pt));
     pts.add(translateBottom(pt));
     pts.add(translateRight(translateBottom(pt)));
     pts.add(translateRight(translateTop(pt)));
     pts.add(translateLeft(translateBottom(pt)));
     pts.add(translateLeft(translateTop(pt)));
     return pts;
     }
    
    
     private Point translateRight(Point p) {
     return new Point(p.x + maxX, p.y);
     }
    
     private Point translateLeft(Point p) {
     return new Point(p.x - maxX, p.y);
     }
    
     private Point translateTop(Point p) {
     return new Point(p.x, p.y + maxY);
     }
    
     private Point translateBottom(Point p) {
     return new Point(p.x, p.y - maxY);
     }*/
    private double getDistance(Point p2) {
        return Math.sqrt(Math.pow(this.x - p2.x, 2) + Math.pow(this.y - p2.y, 2));
    }

    private double getDistance(double a, double b) {
        return Math.sqrt(Math.pow(this.x - a, 2) + Math.pow(this.y - b, 2));
    }
}
