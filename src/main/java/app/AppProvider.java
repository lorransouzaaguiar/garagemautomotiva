package app;

import javax.swing.JOptionPane;

public class AppProvider {
	
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
