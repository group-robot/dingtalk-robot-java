package io.github.group.robot.dingtalk.core.type;

/**
 * ActionCard消息是否隐藏头像枚举值
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
public enum HideAvatarType {
    /**
     * 发消息的时候，隐藏机器人头像
     */
    HIDE("隐藏", 1),

    /**
     * 发消息的时候，显示机器人头像
     */
    UNHIDE("不隐藏，正常显示", 0);
    private final String comment;

    private final Integer value;

    HideAvatarType(String comment, Integer value) {
        this.comment = comment;
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public Integer getValue() {
        return value;
    }
}
