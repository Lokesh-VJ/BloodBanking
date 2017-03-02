package net.bloodbanking.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bloodbanking.constants.ErrorConstants;
import net.bloodbanking.dao.LoginDao;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.EnquiryFormDTO.validateProcessEnquiry;
import net.bloodbanking.entity.Registration;
import net.bloodbanking.exception.ApplicationException;
import net.bloodbanking.exception.ApplicationMessage;
import net.bloodbanking.validator.BaseValidator;
import net.bloodbanking.validator.EnquiryValidator;

@Component("enquiryValidator")
public class EnquiryValidatorImpl extends BaseValidator<EnquiryFormDTO> implements EnquiryValidator {
	
	@Override
	public void validateProcessEnquiry(EnquiryFormDTO enquiryFormDTO) throws ApplicationException {
		List<ApplicationMessage> messages = new ArrayList<ApplicationMessage>();
		validateDTOGroups(enquiryFormDTO, false, validateProcessEnquiry.class);
		throwExceptionOnValidation(messages);
	}
}