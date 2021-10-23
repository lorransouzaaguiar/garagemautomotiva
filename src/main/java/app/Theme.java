package app;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
public class Theme {
	
	
	public static void start() {
		try {
		    UIManager.setLookAndFeel( new FlatDarculaLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
	}
}	
