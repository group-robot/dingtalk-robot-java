package io.github.group.robot.dingtalk.core.model;

import io.github.group.robot.dingtalk.core.model.internal.Link;
import org.junit.jupiter.api.Test;

class FeedCardMessageTest extends DingTalkMessageTest {

    @Test
    void sendMessage() {
        FeedCardMessage message = FeedCardMessage.FeedCardMessageBuilder
            .builder()
            .addLink(
                Link.builder()
                    .title("时代的火车向前开1")
                    .messageUrl("https://www.dingtalk.com/")
                    .picUrl("https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.pn")
                    .build()
                ,
                Link.builder()
                    .title("时代的火车向前开2")
                    .messageUrl("https://www.dingtalk.com/")
                    .picUrl("https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png")
                    .build()
            ).build();
        sendMessage(message);
    }
}
