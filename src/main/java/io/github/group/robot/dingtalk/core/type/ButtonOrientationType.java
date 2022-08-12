package io.github.group.robot.dingtalk.core.type;

/**
 * ActionCard消息按钮布局枚举值
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
public enum ButtonOrientationType {
    /**
     * 水平布局
     */
    HORIZONTAL("水平布局", 1),
    /**
     * 垂直布局
     */
    VERTICAL("垂直布局", 0);
    private final String comment;
    private final Integer value;

    ButtonOrientationType(String comment, Integer value) {
        this.value = value;
        this.comment = comment;
    }

    public Integer getValue() {
        return value;
    }

    public String getComment() {
        return comment;
    }
}
