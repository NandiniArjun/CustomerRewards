package com.sky.rewards;

import static org.junit.Assert.assertEquals;

import com.sky.customer.EligibilityService;
import org.junit.Test;

import com.sky.customer.EligibilityService.Eligibility;
import com.sky.customer.InvalidAccountNumberException;
import com.sky.stubs.EligibilityServiceStub;

public class EligibilityServiceTest {

    private EligibilityService eligibilityService = new EligibilityServiceStub();

    @Test
    public void testEligibility() {
        try {
            assertEquals(eligibilityService.checkEligibility("100001"), Eligibility.CUSTOMER_ELIGIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEligibilityInvalid() {
        try {
            Eligibility eligibility = eligibilityService.checkEligibility("100007");
            new AssertionError();
        } catch (Exception e) {
            assert (e instanceof InvalidAccountNumberException);
        }

    }
}
