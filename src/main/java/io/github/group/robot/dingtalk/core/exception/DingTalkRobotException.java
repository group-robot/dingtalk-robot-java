package io.github.group.robot.dingtalk.core.exception;

/**
 * 异常
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
public class DingTalkRobotException extends RuntimeException {
    public DingTalkRobotException() {
    }

    public DingTalkRobotException(String message) {
        super(message);
    }

    public DingTalkRobotException(String message, Throwable cause) {
        super(message, cause);
    }
}
