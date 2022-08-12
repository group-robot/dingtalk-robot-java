package io.github.group.robot.dingtalk.core.model;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.util.StrUtil;
import io.github.group.robot.dingtalk.core.type.MessageType;
import io.github.group.robot.dingtalk.core.exception.DingTalkRobotException;
import io.github.group.robot.dingtalk.core.model.internal.AtMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * markdown 类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
public class MarkdownMessage extends BaseMessage {
    /**
     * 首屏会话透出的展示内容
     * <p>是否必填: 是</p>
     */
    private String title;
    /**
     * markdown格式的消息
     * <p>是否必填: 是</p>
     */
    private String text;
    /**
     * @ 信息
     * <p>是否必填: 否</p>
     */
    private AtMessage atMessage;

    @Override
    protected void init() {
        this.messageType = MessageType.MARKDOWN;
    }

    @Override
    protected MessageType getType() {
        return this.messageType;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.text) || StrUtil.isBlank(this.title)) {
            throw new DingTalkRobotException("params validate missing");
        }
        Map<String, Object> markdownMessage = new HashMap<>(2);
        markdownMessage.put("title", this.title);
        markdownMessage.put("text", this.text);

        Map<String, Object> message = new HashMap<>(3);
        message.put("markdown", markdownMessage);
        message.put("msgtype", this.messageType.getValue());
        if (null != this.atMessage) {
            message.put("at", this.atMessage.toMessageMap());
        }
        return message;
    }

    /**
     * {@link  MarkdownMessage} builder
     */
    public static class MarkdownMessageBuilder implements Builder<MarkdownMessage> {
        private final MarkdownMessage message;

        /**
         * create {@link  MarkdownMessageBuilder}
         *
         * @return {@link  MarkdownMessageBuilder}
         */
        public static MarkdownMessageBuilder builder() {
            return new MarkdownMessageBuilder();
        }

        public MarkdownMessageBuilder() {
            this(new MarkdownMessage());
        }

        public MarkdownMessageBuilder(MarkdownMessage message) {
            this.message = message;
        }

        /**
         * set markdown message title
         *
         * @param title title
         * @return this
         * @see #setTitle(String)
         */
        public MarkdownMessageBuilder title(String title) {
            this.message.setTitle(title);
            return this;
        }

        /**
         * set markdown message text
         *
         * @param text text
         * @return this
         * @see #setText(String)
         */
        public MarkdownMessageBuilder text(String text) {
            this.message.setText(text);
            return this;
        }

        /**
         * set markdown message at
         *
         * @param atMessage at message
         * @return this
         * @see #setAtMessage(AtMessage)
         */
        public MarkdownMessageBuilder at(AtMessage atMessage) {
            this.message.setAtMessage(atMessage);
            return this;
        }

        @Override
        public MarkdownMessage build() {
            return this.message;
        }
    }
}
