package com.cyborck.chaosGame;

public class Main {
    private static ChaosGame chaosGame;
    private static Gui gui;

    public static void main ( String[] args ) {
        System.setProperty( "sun.java2d.uiScale", "1.0" );

        int width = 1000;
        int height = 1000;
        int repetitions = 100000000;

        chaosGame = new ChaosGame( width, height, 3 );
        gui = new Gui( width, height );

        run( repetitions );
    }

    private static void run ( int repetitions ) {
        for ( int i = 0; i < repetitions; i++ ) {
            Point next = chaosGame.next();
            gui.addPoint( next );
        }
    }
}
