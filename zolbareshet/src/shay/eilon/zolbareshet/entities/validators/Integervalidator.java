package shay.eilon.zolbareshet.entities.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by eilons on 3/3/2016.
 */
@FacesValidator("integervalidator")
public class Integervalidator implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {

        try {
            if(value!=null) {
                Integer.parseInt((String) value);
            }
            else{
                throw new Exception();
            }
        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage("Validation failed.", "Not a number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}
