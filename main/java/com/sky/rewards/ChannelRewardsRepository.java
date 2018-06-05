package com.sky.rewards;

import java.util.HashMap;

import com.sky.Channel;
import com.sky.rewards.Reward;

public class ChannelRewardsRepository extends HashMap<Channel, Reward> {
    // SPORTS CHAMPIONS_LEAGUE_FINAL_TICKET
    // KIDS N/A
    // MUSIC KARAOKE_PRO_MICROPHONE
    // NEWS N/A
    // MOVIES PIRATES_OF_THE_CARIBBEAN_COLLECTION

    public ChannelRewardsRepository() {
        put(Channel.SPORTS, Reward.CHAMPIONS_LEAGUE_FINAL_TICKET);
        put(Channel.MUSIC, Reward.KARAOKE_PRO_MICROPHONE);
        put(Channel.MOVIES, Reward.PIRATES_OF_THE_CARIBBEAN_COLLECTION);
    }
}
