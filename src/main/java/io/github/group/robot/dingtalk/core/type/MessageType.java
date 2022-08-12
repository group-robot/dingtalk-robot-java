package io.github.group.robot.dingtalk.core.type;

/**
 * 消息类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
public enum MessageType {
    /**
     * text类型
     *
     * @see io.github.group.robot.dingtalk.core.model.TextMessage
     */
    TEXT("text"),
    /**
     * link类型
     *
     * @see io.github.group.robot.dingtalk.core.model.LinkMessage
     */
    LINK("link"),
    /**
     * markdown
     *
     * @see io.github.group.robot.dingtalk.core.model.MarkdownMessage
     */
    MARKDOWN("markdown"),
    /**
     * actionCard
     *
     * @see io.github.group.robot.dingtalk.core.model.ActionCardMessage
     */
    ACTION_CARD("actionCard"),
    /**
     * FeedCard
     *
     * @see io.github.group.robot.dingtalk.core.model.FeedCardMessage
     */
    FEED_CARD("feedCard"),
    ;
    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
