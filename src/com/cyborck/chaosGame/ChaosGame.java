package com.cyborck.chaosGame;

public class ChaosGame {
    private final Point[] corners;
    private final double factor;
    private final Restriction r;

    private Point last;
    private int lastCornerIndex;
    private int penultimateCornerIndex;

    public ChaosGame ( int width, int height, double factor, Restriction r, Point... corners ) {
        this.corners = corners;
        this.factor = factor;
        this.r = r;

        last = Point.random( width, height );
        lastCornerIndex = 0;
        penultimateCornerIndex = 0;
    }

    public ChaosGame ( int width, int height, double factor, Restriction r, int startPointCount ) {
        // generate random start points
        corners = new Point[ startPointCount ];
        for ( int i = 0; i < startPointCount; i++ )
            corners[ i ] = Point.random( width, height );
        this.factor = factor;
        this.r = r;

        last = Point.random( width, height );
        lastCornerIndex = 0;
        penultimateCornerIndex = 0;
    }

    public static ChaosGame pointsAroundCircle ( int width, int height, double factor, Restriction r, int startPointCount, double radius ) {
        double offsetX = width / 2d;
        double offsetY = height / 2d;

        Point[] points = new Point[ startPointCount ];

        double alpha = -Math.PI / 2;
        double alphaIncrease = 2 * Math.PI / startPointCount;
        for ( int i = 0; i < startPointCount; i++, alpha += alphaIncrease ) {
            double x = offsetX + Math.cos( alpha ) * radius;
            double y = offsetY + Math.sin( alpha ) * radius;
            points[ i ] = new Point( x, y );
        }

        return new ChaosGame( width, height, factor, r, points );
    }

    public Point next () {
        int cornerIndex = -1;

        switch ( r ) {
            case R0 -> cornerIndex = ( int ) ( Math.random() * corners.length );
            case R1 -> {
                do {
                    cornerIndex = ( int ) ( Math.random() * corners.length );
                } while ( cornerIndex == lastCornerIndex );
            }
            case R2 -> {
                do {
                    cornerIndex = ( int ) ( Math.random() * corners.length );
                } while ( cornerIndex == lastCornerIndex - 1 || ( lastCornerIndex == 0 && cornerIndex == corners.length - 1 ) );
            }
            case R3 -> {
                do {
                    cornerIndex = ( int ) ( Math.random() * corners.length );
                } while ( cornerIndex == lastCornerIndex - 1 || cornerIndex == lastCornerIndex + 1 || ( lastCornerIndex == 0 && cornerIndex == corners.length - 1 )
                        || ( lastCornerIndex == corners.length - 1 && cornerIndex == 0 ) );
            }
            case R4 -> {
                do {
                    cornerIndex = ( int ) ( Math.random() * corners.length );
                } while ( cornerIndex == lastCornerIndex - 2 || ( lastCornerIndex == 0 && cornerIndex == corners.length - 2 ) || ( lastCornerIndex == 1 && cornerIndex == corners.length - 1 ) );
            }
            case R5 -> {
                do {
                    cornerIndex = ( int ) ( Math.random() * corners.length );
                } while ( cornerIndex == lastCornerIndex - 2 || cornerIndex == lastCornerIndex + 2 || ( lastCornerIndex == 0 && cornerIndex == corners.length - 2 )
                        || ( lastCornerIndex == 1 && cornerIndex == corners.length - 1 ) || ( lastCornerIndex == corners.length - 2 && cornerIndex == 0 )
                        || ( lastCornerIndex == corners.length - 1 && cornerIndex == 1 ) );
            }
            case R6 -> {
                do {
                    cornerIndex = ( int ) ( Math.random() * corners.length );
                } while ( lastCornerIndex == penultimateCornerIndex && cornerIndex == lastCornerIndex );
            }
            case R7 -> {
                do {
                    cornerIndex = ( int ) ( Math.random() * corners.length );
                } while ( lastCornerIndex == penultimateCornerIndex && ( cornerIndex == lastCornerIndex - 1 || cornerIndex == lastCornerIndex + 1 || ( lastCornerIndex == 0 && cornerIndex == corners.length - 1 )
                        || ( lastCornerIndex == corners.length - 1 && cornerIndex == 0 ) ) );
            }
        }
        Point corner = corners[ cornerIndex ];

        double centerX = last.getX() + ( corner.getX() - last.getX() ) * factor;
        double centerY = last.getY() + ( corner.getY() - last.getY() ) * factor;
        Point center = new Point( centerX, centerY );

        last = center;
        penultimateCornerIndex = lastCornerIndex;
        lastCornerIndex = cornerIndex;

        return center;
    }

    public enum Restriction {
        R0, // no restrictions
        R1, // not allowed to use the previous corner again
        R2, // corner cannot be one place (anti-clockwise) away from previous corner
        R3, // corner cannot be one place (both directions) away from previous corner
        R4, // corner cannot be two places (anti-clockwise) away from previous corner
        R5, // corner cannot be two places (both directions) away from previous corner
        R6, // corner cannot be the same as the previous chosen corner if the two previously chosen corners are the same
        R7, // corner cannot neighbour the previous chosen corner if the two previously chosen corners are the same
    }
}
