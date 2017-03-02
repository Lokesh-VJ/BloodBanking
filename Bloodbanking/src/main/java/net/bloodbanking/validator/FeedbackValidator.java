package net.bloodbanking.validator;

import net.bloodbanking.dto.FeedbackDTO;
import net.bloodbanking.exception.ApplicationException;

public interface FeedbackValidator extends Validator<FeedbackDTO> {
	void validateProcessFeedback(FeedbackDTO feedbackDTO) throws ApplicationException;
}
