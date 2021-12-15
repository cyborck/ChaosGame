package com.cyborck.chaosGame;

public class Main {
    private static ChaosGame chaosGame;
    private static Gui gui;

    public static void main ( String[] args ) {
        System.setProperty( "sun.java2d.uiScale", "1.0" );

        int width = 2000;
        int height = 2000;
        int repetitions = 500000000;

        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R7, 5, width / 2d );
        gui = new Gui( width, height );

        run( repetitions );
    }

    private static void run ( int repetitions ) {
        for ( int i = 0; i < repetitions; i++ ) {
            Point next = chaosGame.next();
            gui.addPoint( next );
        }
    }

    private static void configurations () {
        int width = 2000;
        int height = 2000;

        // list of cool looking configurations
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R0, 3, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .6, ChaosGame.Restriction.R0, 8, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .51, ChaosGame.Restriction.R0, 4, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, 1.5, ChaosGame.Restriction.R0, 3, width / 7.5 );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, 1.6, ChaosGame.Restriction.R0, 3, width / 7.5 );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, 1.6, ChaosGame.Restriction.R0, 4, width / 10d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R1, 4, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R1, 5, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R1, 10, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R2, 4, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R2, 3, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R2, 5, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .6, ChaosGame.Restriction.R2, 10, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R3, 5, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R3, 10, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R4, 4, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .4, ChaosGame.Restriction.R5, 5, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R5, 8, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .6, ChaosGame.Restriction.R5, 8, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .7, ChaosGame.Restriction.R5, 20, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R6, 4, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R6, 5, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R7, 4, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R7, 5, width / 2d );
        chaosGame = ChaosGame.pointsAroundCircle( width, height, .5, ChaosGame.Restriction.R7, 6, width / 2d );
    }
}
