package shared.br.com.formSwing.internal;
import java.util.HashMap;
import java.util.Map;

public class Validator {
	private Map<String, String> errorList;
	
	public Validator() {
		this.errorList = new HashMap<>();
	}
	
	public void verifyError(String attribute, boolean validation, String errorMessage) {
		if(!this.errorList.containsKey(attribute) && validation == false)
			this.errorList.put(attribute, errorMessage);
		
		if(this.errorList.containsKey(attribute)  && validation == true) {
			this.errorList.remove(attribute);
		}
	}
	
	public Map<String, String> getErrorList() {
		return errorList;
	}
}
