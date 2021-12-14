package com.cyborck.chaosGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Gui extends JFrame {
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color POINT_COLOR = new Color( 1f, 1f, 1f, 0.1f );
    private static final double POINT_RADIUS = 0.5;

    private final PointDrawer pd;

    public Gui ( int width, int height ) {
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setResizable( false );

        pd = new PointDrawer( width, height );
        getContentPane().add( pd );

        pack();
        setLocationRelativeTo( null );
        setVisible( true );
    }

    public void addPoint ( Point p ) {
        pd.addPoint( p );
    }

    private static class PointDrawer extends Component {
        private final Image image;
        private final Graphics imageGraphics;

        public PointDrawer ( int width, int height ) {
            image = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
            imageGraphics = image.getGraphics();
            imageGraphics.setColor( BACKGROUND_COLOR );
            imageGraphics.fillRect( 0, 0, width, height );
            imageGraphics.setColor( POINT_COLOR );

            setPreferredSize( new Dimension( width, height ) );
        }

        public void addPoint ( Point p ) {
            int x = ( int ) ( p.getX() - POINT_RADIUS );
            int y = ( int ) ( p.getY() - POINT_RADIUS );
            int size = ( int ) ( 2 * POINT_RADIUS );
            imageGraphics.fillOval( x, y, size, size );
        }

        @Override
        public void paint ( Graphics g ) {
            g.drawImage( image, 0, 0, this );
            repaint();
        }
    }
}
