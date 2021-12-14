package com.cyborck.chaosGame;

import java.util.ArrayList;
import java.util.List;

public class ChaosGame {
    private final Point[] corners;
    private final List<Point> points;

    public ChaosGame ( int width, int height, Point... corners ) {
        this.corners = corners;

        points = new ArrayList<>();
        points.add( Point.random( width, height ) );
    }

    public ChaosGame ( int width, int height, int startPointCount ) {
        // generate random start points
        corners = new Point[ startPointCount ];
        for ( int i = 0; i < startPointCount; i++ )
            corners[ i ] = Point.random( width, height );

        points = new ArrayList<>();
        points.add( Point.random( width, height ) );
    }

    public Point next () {
        int r = ( int ) ( Math.random() * corners.length );

        Point last = points.get( points.size() - 1 );
        Point corner = corners[ r ];

        double centerX = ( last.getX() + corner.getX() ) / 2;
        double centerY = ( last.getY() + corner.getY() ) / 2;
        Point center = new Point( centerX, centerY );

        points.add( center );

        return center;
    }
}
