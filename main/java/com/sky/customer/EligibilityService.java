package com.sky.customer;

import com.sky.customer.InvalidAccountNumberException;
import com.sky.customer.TechnicalFailureException;

public interface EligibilityService {

    enum Eligibility {
        CUSTOMER_ELIGIBLE, CUSTOMER_INELIGIBLE
    }

    Eligibility checkEligibility(String accountNumber) throws InvalidAccountNumberException, TechnicalFailureException;
}
