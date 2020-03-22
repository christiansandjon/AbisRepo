package be.abis.ex.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import be.abis.ex.model.VatNumber;

@FacesValidator("vatNumberValidator")
public class VatNumberValidator implements Validator {

@Override
public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
	VatNumber vatNr = (VatNumber) value;
	boolean valid = (vatNr.getCountryCode().equalsIgnoreCase("BE") && vatNr.getId().length()==10 ? true : false);
	
	if (!valid) {
	FacesMessage message = new FacesMessage("bad vat number");
	throw new ValidatorException(message);
	}
	
}
}