package com.sky.rewards;

import java.util.List;

import com.sky.Channel;

import com.sky.rewards.Reward;

public interface RewardsService {
    List<Reward> getRewards(String accountNumber, List<Channel> subscribedChannels);
}