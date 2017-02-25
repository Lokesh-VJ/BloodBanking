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
import net.bloodbanking.exception.NhanceApplicationException;
import net.bloodbanking.exception.NhanceApplicationMessage;

public abstract class BaseValidator<T extends BaseDTO> implements Validator<T> {

	@Autowired
	private javax.validation.Validator validator;
	
	protected void validateDTO( T dto ) throws NhanceApplicationException {
		throwExceptionOnConstraintViolation(validator.validate( dto ));
	}
	
	protected void validateDTOPartial( T dto, String... values ) throws NhanceApplicationException {
		for (String string : values) {
			throwExceptionOnConstraintViolation(validator.validateProperty( dto, string ));
		}
	}
	
	protected void validateDTOGroups( T dto, boolean includeDefault, Class<?>... groups ) throws NhanceApplicationException {
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
	
	private void throwExceptionOnConstraintViolation( Set<ConstraintViolation<T>> violations ) throws NhanceApplicationException {
		if(!violations.isEmpty()) {
			List<NhanceApplicationMessage> messages = new ArrayList<NhanceApplicationMessage>();
			for (ConstraintViolation<T> violation : violations) {
				messages.add(new NhanceApplicationMessage(ErrorConstants.VALIDATION_ERROR, 
						violation.getPropertyPath() + " " + violation.getMessage()));
			}
			throwExceptionOnValidation(messages);
		}
	}
	
	protected void throwExceptionOnValidation( List<NhanceApplicationMessage> messages ) throws NhanceApplicationException {
		if( CollectionUtils.isNotEmpty(messages) ) {
			throw new NhanceApplicationException(messages);
		}
	}
}
