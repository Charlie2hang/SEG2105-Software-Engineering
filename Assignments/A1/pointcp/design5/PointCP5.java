package design5;

public abstract class PointCP5 {
    private double xOrRho;
    private double yOrRho;



    public PointCP5() {}

    public abstract double getY();
    public abstract double getX();

    public abstract double getRho();
    public abstract double getTheta();

    public abstract PointCP3 convertStorageToCartesian();
    public abstract PointCP2 convertStorageToPolar();

    public abstract String toString();

    public abstract double getDistance(PointCP5 pointB);

    public abstract PointCP5 rotatePoint(double rotation);

}
