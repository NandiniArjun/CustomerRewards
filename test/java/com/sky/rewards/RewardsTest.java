package com.sky.rewards;

import java.util.Arrays;
import java.util.List;

import com.sky.rewards.Reward;
import org.junit.Test;

import com.sky.Channel;
import com.sky.customer.InvalidAccountNumberException;
import com.sky.stubs.EligibilityServiceStub;

import com.sky.rewards.RewardsService;
import com.sky.rewards.RewardsServiceImpl;

public class RewardsTest {

    private RewardsService rewardsService = new RewardsServiceImpl(new EligibilityServiceStub());

    @Test
    public void testReward() {
        List<Reward> rewards = rewardsService.getRewards("100001", Arrays.asList(Channel.SPORTS));
        assert (rewards.contains(Reward.CHAMPIONS_LEAGUE_FINAL_TICKET));
    }

    @Test
    public void testRewardFalse() {
        List<Reward> rewards = rewardsService.getRewards("100001", Arrays.asList(Channel.KIDS));
        assert (rewards.isEmpty());
    }

    @Test
    public void testRewardInvalidAccount() {
        try {
            List<Reward> rewards = rewardsService.getRewards("100007", Arrays.asList(Channel.KIDS));
        } catch (Exception e) {
            assert (e instanceof InvalidAccountNumberException);
        }
    }
}
