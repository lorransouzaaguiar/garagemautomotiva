package shared;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Observable {
	
	protected PropertyChangeSupport support = new PropertyChangeSupport(this);
	
	public void addListener(PropertyChangeListener listener) {
		this.support.addPropertyChangeListener(listener);
	}
	
	public void removeListener(PropertyChangeListener listener) {
		this.removeListener(listener);
	}
}
