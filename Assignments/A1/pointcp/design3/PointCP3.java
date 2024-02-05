package design3;


import design2.PointCP2;
import design5.PointCP5;

import java.util.Objects;

public class PointCP3 {
    /**
     * Contains the current value of RHO depending on the type
     * of coordinates.
     */
    private double x;

    /**
     * Contains the current value of THETA value depending on the
     * type of coordinates.
     */
    private double y;

    public PointCP3(double x,double y){

        this.x=x;
        this.y=y;

    }
    public double getY() { return y; }
    public double getX(){return x;}
    public double getRho() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public double getTheta() {
        return Math.toDegrees(Math.atan2(y, x));
    }


    public PointCP2 convertStorageToPolar(){
        PointCP2 point = new PointCP2(getRho(),getTheta());
        return point;
    }
    public PointCP3 convertStorageToCartesian(){
        return this;
    }
    public double getDistance(PointCP3 pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP3 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP3((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    public String toString()
    {
        return "The  point in Cartesian system coordinates (X,Y) is ("+ getX()+", "+getY()+")";
    }

}
