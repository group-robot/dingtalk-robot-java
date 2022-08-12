package io.github.group.robot.dingtalk.core.model;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.util.StrUtil;
import io.github.group.robot.dingtalk.core.exception.DingTalkRobotException;
import io.github.group.robot.dingtalk.core.type.ButtonOrientationType;
import io.github.group.robot.dingtalk.core.type.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 整体跳转ActionCard类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
public class SingleActionCardMessage extends BaseMessage {
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
     * 单个按钮的标题
     * <p>是否必填: 是</p>
     */
    private String singleTitle;
    /**
     * 点击消息跳转的URL
     * <p>是否必填: 是</p>
     */
    private String singleUrl;
    /**
     * button 布局
     * <p>是否必填: 否</p>
     */
    private ButtonOrientationType btnOrientation;

    @Override
    protected void init() {
        this.messageType = MessageType.ACTION_CARD;
    }

    @Override
    protected MessageType getType() {
        return this.messageType;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.text) || StrUtil.isBlank(this.title) || StrUtil.isBlank(this.singleTitle) || StrUtil.isBlank(this.singleUrl)) {
            throw new DingTalkRobotException("params validate missing");
        }
        Map<String, Object> singleMessage = new HashMap<>(5);
        singleMessage.put("title", this.title);
        singleMessage.put("text", this.text);
        singleMessage.put("singleTitle", this.singleTitle);
        singleMessage.put("singleURL", this.singleUrl);
        if (null != this.btnOrientation) {
            singleMessage.put("btnOrientation", this.btnOrientation.getValue());
        }
        Map<String, Object> message = new HashMap<>(2);
        message.put("msgtype", this.messageType.getValue());
        message.put("actionCard", singleMessage);
        return message;
    }

    /**
     * {@link  SingleActionCardMessage} builder
     */
    public static class SingleActionCardMessageBuilder implements Builder<SingleActionCardMessage> {
        private final SingleActionCardMessage message;

        /**
         * create {@link  SingleActionCardMessageBuilder}
         *
         * @return this
         */
        public static SingleActionCardMessageBuilder builder() {
            return new SingleActionCardMessageBuilder();
        }

        public SingleActionCardMessageBuilder() {
            this(new SingleActionCardMessage());
        }

        public SingleActionCardMessageBuilder(SingleActionCardMessage message) {
            this.message = message;
        }

        /**
         * set {@link  SingleActionCardMessage} title
         *
         * @param title title
         * @return this
         * @see #setTitle(String)
         */
        public SingleActionCardMessageBuilder title(String title) {
            this.message.setTitle(title);
            return this;
        }

        /**
         * set {@link  SingleActionCardMessage} text
         *
         * @param text title
         * @return this
         * @see #setText(String)
         */
        public SingleActionCardMessageBuilder text(String text) {
            this.message.setText(text);
            return this;
        }

        /**
         * set {@link  SingleActionCardMessage} singleTitle
         *
         * @param singleTitle singleTitle
         * @return this
         * @see #setSingleTitle(String)
         */
        public SingleActionCardMessageBuilder singleTitle(String singleTitle) {
            this.message.setSingleTitle(singleTitle);
            return this;
        }

        /**
         * set {@link  SingleActionCardMessage} singleUrl
         *
         * @param singleUrl singleUrl
         * @return this
         * @see #setSingleUrl(String)
         */
        public SingleActionCardMessageBuilder singleUrl(String singleUrl) {
            this.message.setSingleUrl(singleUrl);
            return this;
        }

        /**
         * set {@link  SingleActionCardMessage} btnOrientation
         *
         * @param button btnOrientation
         * @return this
         * @see #setBtnOrientation(ButtonOrientationType)
         */
        public SingleActionCardMessageBuilder btnOrientation(ButtonOrientationType button) {
            this.message.setBtnOrientation(button);
            return this;
        }

        @Override
        public SingleActionCardMessage build() {
            return this.message;
        }
    }
}
