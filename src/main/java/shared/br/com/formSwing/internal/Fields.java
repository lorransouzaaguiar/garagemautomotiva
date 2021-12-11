package shared.br.com.formSwing.internal;
import java.util.HashMap;
import java.util.Map;

public class Fields {
	private Map<String, Input> fields;
	
	public Fields() {
		this.fields = new HashMap<String, Input>();
	}
	
	public void put(String key, Input value) {
		this.fields.put(key, value);
	}
	
	public Map<String, Input> getAllFields() {
		return this.fields;
	}
}
