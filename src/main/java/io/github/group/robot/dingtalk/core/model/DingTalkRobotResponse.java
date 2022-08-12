package io.github.group.robot.dingtalk.core.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 钉钉返回的消息体，可以根据errcode和errmsg
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Data
public class DingTalkRobotResponse implements Serializable {
    /**
     * 错误码
     */
    private Integer errcode;

    /**
     * 错误信息
     */
    private String errmsg;

    public boolean isSuccess() {
        return errcode == 0;
    }
}
