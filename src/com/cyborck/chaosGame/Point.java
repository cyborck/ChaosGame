package com.cyborck.chaosGame;

public class Point {
    private double x;
    private double y;

    public Point ( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public static Point random ( double maxX, double maxY ) {
        double x = Math.random() * maxX;
        double y = Math.random() * maxY;
        return new Point( x, y );
    }

    public double getX () {
        return x;
    }

    public void setX ( double x ) {
        this.x = x;
    }

    public double getY () {
        return y;
    }

    public void setY ( double y ) {
        this.y = y;
    }
}
