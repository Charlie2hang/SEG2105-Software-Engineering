package design2;


import design3.PointCP3;
import design5.PointCP5;

import java.util.Objects;

public class PointCP2{
    /**
     * Contains the current value of RHO depending on the type
     * of coordinates.
     */
    private double rho;

    /**
     * Contains the current value of THETA value depending on the
     * type of coordinates.
     */
    private double theta;

    public PointCP2(double rho,double theta){

        this.theta=theta;
        this.rho=rho;

    }
    public double getY() {
        return (Math.sin(Math.toRadians(theta)) * rho);
    }
    public double getX(){

        return (Math.cos(Math.toRadians(theta)) * rho);
    }
    public double getRho() {
        return rho;
    }

    public double getTheta() {
        return theta;
    }


    public PointCP3 convertStorageToCartesian(){
        PointCP3 point = new PointCP3(getX(),getY());
        return point;
    }
    public PointCP2 convertStorageToPolar(){
        return this;
    }
    public String toString()
    {
        return "The  point in Polar system coordinates (RHO,THETA) is ("+ getRho()+", "+getTheta()+")";
    }
    public double getDistance(PointCP2 pointB)
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
    public PointCP2 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP2((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }


}
