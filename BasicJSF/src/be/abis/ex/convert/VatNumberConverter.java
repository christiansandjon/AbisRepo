package be.abis.ex.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import be.abis.ex.model.VatNumber;

@FacesConverter("vatNumberConverter")
public class VatNumberConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String inValue) throws ConverterException {
		VatNumber vatNumber = null;
		
		try {
		String codeCountry = inValue.substring(0, 2);
		String id =inValue.substring(2).replaceAll("[^a-zA-Z0-9]", "");
		
		vatNumber = new VatNumber(codeCountry,id);
		
		} catch (Exception e) {
		FacesMessage message = new FacesMessage("wrong vat number");
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ConverterException(message);
		}
		return vatNumber;
		}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value ) throws ConverterException {
		VatNumber vatNumber = (VatNumber) value;
		return (vatNumber!=null)? vatNumber.toString() : "";
		
	}

}
