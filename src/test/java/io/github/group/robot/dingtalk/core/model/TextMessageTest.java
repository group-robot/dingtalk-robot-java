package io.github.group.robot.dingtalk.core.model;

import io.github.group.robot.dingtalk.core.model.internal.AtMessage;
import org.junit.jupiter.api.Test;

class TextMessageTest extends DingTalkMessageTest {

    @Test
    void sendMessage() {
        TextMessage message = TextMessage.TextMessageBuilder.builder().at(
            AtMessage.AtMessageBuilder.builder()
                .atAll(true)
                .build()
        ).content("我就是我,不一样的烟火").build();
        sendMessage(message);
    }
}
