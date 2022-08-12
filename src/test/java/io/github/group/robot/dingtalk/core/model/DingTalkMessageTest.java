package io.github.group.robot.dingtalk.core.model;

import io.github.group.robot.dingtalk.core.DingTalkRobotClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Slf4j
public class DingTalkMessageTest {

    void sendMessage(BaseMessage message) {
        DingTalkRobotClient client = new DingTalkRobotClient(System.getenv("webhook"), System.getenv("secret"));
        DingTalkRobotResponse response = client.sendMessage(message);
        Assertions.assertTrue(response.isSuccess());
        log.info("result: {}", response);
    }

}
