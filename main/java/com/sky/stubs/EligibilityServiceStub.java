package com.sky.stubs;

import java.util.HashMap;
import java.util.Map;

import com.sky.customer.InvalidAccountNumberException;
import com.sky.customer.TechnicalFailureException;
import com.sky.customer.EligibilityService;

public class EligibilityServiceStub implements EligibilityService {

    private Map<String, Boolean> accountEligibility = new HashMap<String, Boolean>();

    public EligibilityServiceStub() {
        accountEligibility.put("100001", true);
        accountEligibility.put("100002", true);
        accountEligibility.put("100003", true);
        accountEligibility.put("100004", true);
        accountEligibility.put("100005", true);
        accountEligibility.put("100006", false);
        accountEligibility.put("100007", false);
        accountEligibility.put("100008", false);
        accountEligibility.put("100009", false);
        accountEligibility.put("100010", true);
        accountEligibility.put("100011", true);
        accountEligibility.put("100012", false);
    }

    public EligibilityService.Eligibility checkEligibility(String accountNumber)
            throws InvalidAccountNumberException, TechnicalFailureException {

        if (accountEligibility.containsKey(accountNumber)) {
            if (accountEligibility.get(accountNumber)) {
                return Eligibility.CUSTOMER_ELIGIBLE;
            } else {
                return Eligibility.CUSTOMER_INELIGIBLE;
            }
        } else {
            throw new InvalidAccountNumberException("Account number " + accountNumber + " is invalid");
        }
    }

}
