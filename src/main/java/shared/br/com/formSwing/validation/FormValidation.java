package shared.br.com.formSwing.validation;

public class FormValidation {
	
	private StringValidation stringValidation;
	
	public FormValidation() {
		this.stringValidation = new StringValidation();
	}
	
	public StringValidation string() {
		return this.stringValidation;
	}
	
}
