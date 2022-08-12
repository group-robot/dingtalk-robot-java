package io.github.group.robot.dingtalk.core.model;

import io.github.group.robot.dingtalk.core.model.internal.AtMessage;
import org.junit.jupiter.api.Test;

class MarkdownMessageTest extends DingTalkMessageTest {

    @Test
    void sendMessage() {
        MarkdownMessage message = MarkdownMessage.MarkdownMessageBuilder
            .builder()
            .at(
                AtMessage.AtMessageBuilder
                    .builder()
                    .atAll(true)
                    .build()
            )
            .title("杭州天气")
            .text("#### 杭州天气 @150XXXXXXXX \n > 9度，西北风1级，空气良89，相对温度73%\n > ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n > ###### 10点20分发布 [天气](https://www.dingtalk.com) \n")
            .build();
        sendMessage(message);
    }
}
