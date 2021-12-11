package shared.br.com.formSwing;
import shared.br.com.formSwing.internal.Fields;
import shared.br.com.formSwing.internal.Input;
import shared.br.com.formSwing.internal.Validator;
import shared.br.com.formSwing.validation.FormValidation;

public class FormSwing {
	
	private Fields fields;
	private Validator validator;
	private FormValidation formValidation;
	
	public FormSwing() {
		this.fields = new Fields();
		this.validator = new Validator();
		this.formValidation = new FormValidation();
	}
	
	public FormSwing field(String attribute, Input field) {
		this.fields.put(attribute, field);
		return this;
	}
	
	
	public FormSwing attribute(String attribute, boolean validation, String errorMessage) {
		this.validator.verifyError(attribute, validation, errorMessage);
		return this;
	}
	
	public FormValidation formValidation() {
		return this.formValidation;
	}
	
	public boolean isValid() {
		if(this.validator.getErrorList().isEmpty())
			return true;
		return false;
	}
	
	public void showErrors() {
		if(!isValid()) {
			this.validator.getErrorList().forEach((attr, error) -> {
				this.fields.getAllFields().forEach((att, input) -> {
					if(attr.equals(att)) 
						input.setErrorMessage(error);
				});
			});
		}
	}
	
}
