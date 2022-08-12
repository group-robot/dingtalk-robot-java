package io.github.group.robot.dingtalk.core.model;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.util.StrUtil;
import io.github.group.robot.dingtalk.core.type.MessageType;
import io.github.group.robot.dingtalk.core.exception.DingTalkRobotException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * link类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
public class LinkMessage extends BaseMessage {
    /**
     * 消息内容。如果太长只会部分展示。
     * <p>是否必填: 是</p>
     */
    private String text;
    /**
     * 消息标题。
     * <p>是否必填: 是</p>
     */
    private String title;
    /**
     * 图片URL。
     * <p>是否必填: 否</p>
     */
    private String picUrl;
    /**
     * 点击消息跳转的URL
     * <p>是否必填: 是</p>
     */
    private String messageUrl;

    @Override
    protected void init() {
        this.messageType = MessageType.LINK;
    }

    @Override
    protected MessageType getType() {
        return this.messageType;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.title) || StrUtil.isBlank(this.text) || StrUtil.isBlank(this.messageUrl)) {
            throw new DingTalkRobotException("params validate missing");
        }
        Map<String, Object> contentMessage = new HashMap<>(4);
        contentMessage.put("text", this.text);
        contentMessage.put("title", this.title);
        contentMessage.put("picUrl", this.picUrl);
        contentMessage.put("messageUrl", this.messageUrl);
        Map<String, Object> message = new HashMap<>(2);
        message.put("msgtype", this.messageType.getValue());
        message.put("link", contentMessage);
        return message;
    }

    /**
     * {@link  LinkMessage} builder
     */
    public static class LinkMessageBuilder implements Builder<LinkMessage> {
        private final LinkMessage message;

        /**
         * create {@link  LinkMessageBuilder}
         *
         * @return {@link  LinkMessageBuilder}
         */
        public static LinkMessageBuilder builder() {
            return new LinkMessageBuilder();
        }

        public LinkMessageBuilder() {
            this(new LinkMessage());
        }

        public LinkMessageBuilder(LinkMessage message) {
            this.message = message;
        }

        /**
         * set link message title
         *
         * @param title title
         * @return this
         * @see #setTitle(String)
         */
        public LinkMessageBuilder title(String title) {
            this.message.setTitle(title);
            return this;
        }

        /**
         * set link message text
         *
         * @param text text
         * @return this
         * @see #setText(String)
         */
        public LinkMessageBuilder text(String text) {
            this.message.setText(text);
            return this;
        }

        /**
         * set link message messageUrl
         *
         * @param messageUrl messageUrl
         * @return this
         * @see #setMessageUrl(String)
         */
        public LinkMessageBuilder messageUrl(String messageUrl) {
            this.message.setMessageUrl(messageUrl);
            return this;
        }

        /**
         * set link message picUrl
         *
         * @param picUrl picUrl
         * @return this
         * @see #setPicUrl(String)
         */
        public LinkMessageBuilder picUrl(String picUrl) {
            this.message.setPicUrl(picUrl);
            return this;
        }

        @Override
        public LinkMessage build() {
            return this.message;
        }
    }
}
