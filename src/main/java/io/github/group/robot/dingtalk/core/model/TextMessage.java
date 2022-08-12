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
 * 文本请求消息
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Setter
@Getter
public class TextMessage extends BaseMessage {
    /**
     * 消息内容。
     * <p>是否必填: 是</p>
     */
    private String content;
    /**
     * @ 消息信息
     */
    private AtMessage atMessage;

    @Override
    protected void init() {
        this.messageType = MessageType.TEXT;
    }

    @Override
    protected MessageType getType() {
        return this.messageType;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (null == this.messageType || StrUtil.isBlank(this.content)) {
            throw new DingTalkRobotException("message_type or content missing");
        }
        Map<String, Object> contentMessage = new HashMap<>(1);
        contentMessage.put("content", this.content);
        Map<String, Object> message = new HashMap<>(3);
        message.put("msgtype", this.messageType.getValue());
        message.put("text", contentMessage);
        if (null != this.atMessage) {
            message.put("at", atMessage.toMessageMap());
        }
        return message;
    }

    /**
     * {@link  TextMessage} builder
     */
    public static class TextMessageBuilder implements Builder<TextMessage> {
        private final TextMessage message;

        public static TextMessageBuilder builder() {
            return new TextMessageBuilder();
        }

        public TextMessageBuilder() {
            this(new TextMessage());
        }

        public TextMessageBuilder(TextMessage message) {
            this.message = message;
        }

        /**
         * set text content
         *
         * @param content content
         * @return this
         */
        public TextMessageBuilder content(String content) {
            this.message.setContent(content);
            return this;
        }

        /**
         * set at
         *
         * @param message at message
         * @return this
         */
        public TextMessageBuilder at(AtMessage message) {
            this.message.setAtMessage(message);
            return this;
        }


        @Override
        public TextMessage build() {
            return this.message;
        }
    }
}
