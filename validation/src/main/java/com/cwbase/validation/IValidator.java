package com.cwbase.validation;

import com.cwbase.model.Order;

public interface IValidator {

	/**
	 * Validator name.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Order validator, used to check whether to process the order further
	 * 
	 * @param order
	 * @return
	 */
	boolean validate(Order order);
}
