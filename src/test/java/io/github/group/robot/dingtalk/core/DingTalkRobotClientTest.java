package io.github.group.robot.dingtalk.core;

import io.github.group.robot.dingtalk.core.model.DingTalkRobotResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DingTalkRobotClientTest {

    @Test
    void sendMessage() {
        String json = "{\"msgtype\":\"actionCard\",\"actionCard\":{\"title\":\"我 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store " +
            "的前身\",\"text\":\"![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \\n\\n #### 乔布斯 20 年前想打造的苹果咖啡厅 \\n\\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划\",\"btnOrientation\":\"0\",\"btns\":[{\"title\":\"内容不错\",\"actionURL\":\"https://www.dingtalk.com/\"},{\"title\":\"不感兴趣\",\"actionURL\":\"https://www.dingtalk.com/\"}]}}";
        DingTalkRobotClient client = new DingTalkRobotClient(System.getenv("webhook"), System.getenv("secret"));
        DingTalkRobotResponse response = client.sendMessage(json);
        Assertions.assertTrue(response.isSuccess());
    }
}
