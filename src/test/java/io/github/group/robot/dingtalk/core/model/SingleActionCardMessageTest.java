package io.github.group.robot.dingtalk.core.model;

import io.github.group.robot.dingtalk.core.type.ButtonOrientationType;
import org.junit.jupiter.api.Test;

class SingleActionCardMessageTest extends DingTalkMessageTest {

    @Test
    void sendMessage() {
        SingleActionCardMessage message = SingleActionCardMessage.SingleActionCardMessageBuilder
            .builder()
            .title("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身")
            .text("![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png) \n" +
                " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n" +
                " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划")
            .btnOrientation(ButtonOrientationType.VERTICAL)
            .singleTitle("阅读全文")
            .singleUrl("https://www.dingtalk.com/")
            .build();
        sendMessage(message);
    }
}
