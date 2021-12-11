package shared.br.com.formSwing.validation;

public class StringValidation {
	
	public boolean isRequired(String value) {
		 if (value == null || value.trim().length() == 0) 
			 return false;
		 
		 return true;
	}
	
	public boolean isEmail(String text) {
		 String pattern = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		 if (!text.matches(pattern))
	        return false;
		 
		 return true;
	}
	
	public boolean isDigit(String text) {
		String pattern = "^\\d+$";
		if(!text.matches(pattern))
			return false;
		
		return true;
	}
}
