package io.github.group.robot.dingtalk.core.model;

import io.github.group.robot.dingtalk.core.model.internal.ActionCardButton;
import io.github.group.robot.dingtalk.core.type.ButtonOrientationType;
import org.junit.jupiter.api.Test;

class ActionCardMessageTest extends DingTalkMessageTest {

    @Test
    void sendMessage() {
        ActionCardMessage message = ActionCardMessage.ActionCardMessageBuilder.builder()
            .title("我 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身")
            .text("![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \n\n #### 乔布斯 20 年前想打造的苹果咖啡厅 \n\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划")
            .btnOrientation(ButtonOrientationType.VERTICAL)
            .addBtn(
                ActionCardButton.builder()
                    .title("内容不错")
                    .actionUrl("https://www.dingtalk.com/")
                    .build(),
                ActionCardButton.builder()
                    .title("不感兴趣")
                    .actionUrl("https://www.dingtalk.com/")
                    .build()
            ).build();
        sendMessage(message);
    }
}
