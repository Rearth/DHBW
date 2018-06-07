package de.dhbw.probeklausur;

/**
 * Darts counter application
 */
public class DartsCounter {

	/**
	 * Application entry point
	 *
	 * @param args
	 *            command line arguments
	 */
	public static void main( String[] args ) {

		final Board b = new Board();
        System.out.println(b);
        System.out.println(b.parseField("X"));

		final Player[] players = new Player[] { new Player( "Michael van Gerwen" ), new Player( "Rob Cross" )
		};

		final Game g = new Game( b, players );
		g.start();

	}

}
