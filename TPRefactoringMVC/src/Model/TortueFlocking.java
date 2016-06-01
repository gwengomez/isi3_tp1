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

    /*public ArrayList<TortueAutonome> getNeighbourhood() {
        ArrayList<TortueAutonome> neighbour = new ArrayList<>();
        for (Tortue te : tortues) {
            TortueAutonome t = (TortueAutonome)te;
            if (t == this) {
                continue;
            }
            if (this.getDistance(new Point(t.x, t.y)) <= visionRange) {
                neighbour.add(t);
            }
        }
        return neighbour;
    }*/

    /*public Point getCenter(ArrayList<TortueAutonome> ts) {
        double x = 0, y = 0;
        for (TortueAutonome t : ts) {
            x += t.x;
            y += t.y;
        }
        return new Point((int) Math.round((y / (ts.size() - 1))), (int) Math.round(x / (ts.size() - 1)));
    }*/

    @Override
    public void nextStep() {
        // Toutes les tortues en portée de vision (sans prendre en compte l'angle de vision)
        ArrayList<TortueAutonome> inVisionRange = new ArrayList<>();
        // Toutes les tortues qui sont situées dans notre vision et trop proche de nous
        ArrayList<TortueAutonome> tooClose = new ArrayList<>();
        
        // Remplie la liste des tortues en portée de vision (inVisionRange)
        for (Tortue te : tortues) {
            TortueAutonome t = (TortueAutonome)te;
            if (t == this) {
                continue;
            }
            double distance = this.getDistance(new Point(t.x, t.y));
            if (distance <= visionRange) {
                inVisionRange.add(t);
            }
        }
        
        // Toutes les tortues en portée de vision dans l'angle de vision
        ArrayList<TortueAutonome> inRadiusRange = new ArrayList<>();
        
        // Sélectionne les tortues à portée et dans l'angle de la vision (inRadiusRange)
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
                if(this.getDistance(new Point(t.x, t.y)) < distanceMin) {
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
            if(tooClose.isEmpty())
                this.avancer(this.getVitesse());
            else
                this.avancer(this.getVitesse()/2);
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
