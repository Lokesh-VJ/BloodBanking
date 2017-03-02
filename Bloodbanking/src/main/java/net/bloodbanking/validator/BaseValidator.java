package net.bloodbanking.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.groups.Default;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import net.bloodbanking.constants.ErrorConstants;
import net.bloodbanking.dto.BaseDTO;
import net.bloodbanking.exception.ApplicationException;
import net.bloodbanking.exception.ApplicationMessage;

public abstract class BaseValidator<T extends BaseDTO> implements Validator<T> {

	@Autowired
	private javax.validation.Validator validator;
	
	protected void validateDTO( T dto ) throws ApplicationException {
		throwExceptionOnConstraintViolation(validator.validate( dto ));
	}
	
	protected void validateDTOPartial( T dto, String... values ) throws ApplicationException {
		for (String string : values) {
			throwExceptionOnConstraintViolation(validator.validateProperty( dto, string ));
		}
	}
	
	protected void validateDTOGroups( T dto, boolean includeDefault, Class<?>... groups ) throws ApplicationException {
		if( includeDefault ) {
			Class<?>[] tempGroups = new Class[groups.length + 1];
			for (int i = 0; i < groups.length; i++) {
				
				tempGroups[i] = groups[i];
			}
			tempGroups[groups.length] = Default.class;
			groups = tempGroups;
		}
		throwExceptionOnConstraintViolation(validator.validate( dto, groups ));
	}
	
	private void throwExceptionOnConstraintViolation( Set<ConstraintViolation<T>> violations ) throws ApplicationException {
		if(!violations.isEmpty()) {
			List<ApplicationMessage> messages = new ArrayList<ApplicationMessage>();
			for (ConstraintViolation<T> violation : violations) {
				messages.add(new ApplicationMessage(ErrorConstants.VALIDATION_ERROR, 
						violation.getPropertyPath() + " " + violation.getMessage()));
			}
			throwExceptionOnValidation(messages);
		}
	}
	
	protected void throwExceptionOnValidation( List<ApplicationMessage> messages ) throws ApplicationException {
		if( CollectionUtils.isNotEmpty(messages) ) {
			throw new ApplicationException(messages);
		}
	}
}
