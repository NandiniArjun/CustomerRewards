package com.sky.rewards;

import com.sky.Channel;
import com.sky.customer.EligibilityService;
import com.sky.customer.EligibilityService.Eligibility;
import com.sky.customer.InvalidAccountNumberException;
import com.sky.customer.TechnicalFailureException;
import com.sky.rewards.Reward;
import com.sky.rewards.ChannelRewardsRepository;
import com.sky.rewards.RewardsService;

import java.util.ArrayList;
import java.util.List;

public class RewardsServiceImpl implements RewardsService {

    private EligibilityService eligibilityService;
    private ChannelRewardsRepository channelRewardsRepository;

    public RewardsServiceImpl(EligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
        this.channelRewardsRepository = new ChannelRewardsRepository();
    }

    //Prepare a reward list based on customer  and subscription
    public List<Reward> getRewards(String accountNumber, List<Channel> subscribedChannels) {
        List<Reward> rewards = new ArrayList<Reward>();
        try {
            if (eligibilityService.checkEligibility(accountNumber) == Eligibility.CUSTOMER_ELIGIBLE) {
                for (Channel channel : subscribedChannels) {
                    if (channelRewardsRepository.containsKey(channel)) {
                        rewards.add(channelRewardsRepository.get(channel));
                    }
                }
            }
        } catch (InvalidAccountNumberException e) {
            throw new RuntimeException(e.getMessage());
        } catch (TechnicalFailureException e) {
            throw new RuntimeException(e.getMessage());
        }

        return rewards;
    }
}