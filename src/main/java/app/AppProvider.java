package app;

import javax.swing.JOptionPane;

import shared.Observable;

public class AppProvider extends Observable{
	
	private static AppProvider instance = null;
	
	public static AppProvider getInstance() {
		if(instance == null){
			instance = new AppProvider();
		}
		
		return instance;
	}
	
	public void showMessageUI(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
}
