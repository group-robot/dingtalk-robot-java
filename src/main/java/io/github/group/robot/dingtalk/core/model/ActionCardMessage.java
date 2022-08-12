package io.github.group.robot.dingtalk.core.model;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import io.github.group.robot.dingtalk.core.exception.DingTalkRobotException;
import io.github.group.robot.dingtalk.core.model.internal.ActionCardButton;
import io.github.group.robot.dingtalk.core.type.ButtonOrientationType;
import io.github.group.robot.dingtalk.core.type.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 独立跳转ActionCard类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
public class ActionCardMessage extends BaseMessage {
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
     * 按钮布局
     * <p>是否必填: 否</p>
     */
    private ButtonOrientationType btnOrientation;
    /**
     * 按钮
     * <p>是否必填: 是</p>
     */
    private List<ActionCardButton> btns;

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
        if (StrUtil.isBlank(this.title) || StrUtil.isBlank(this.text) || CollectionUtil.isEmpty(this.btns)) {
            throw new DingTalkRobotException("params validate missing");
        }
        List<Map<String, Object>> buttons = new ArrayList<>(this.btns.size());
        for (ActionCardButton btn : this.btns) {
            buttons.add(btn.toMessageMap());
        }
        Map<String, Object> cardMessage = new HashMap<>(4);
        cardMessage.put("title", this.title);
        cardMessage.put("text", this.text);
        if (null != btnOrientation) {
            cardMessage.put("btnOrientation", this.btnOrientation.getValue());
        }
        cardMessage.put("btns", buttons);
        Map<String, Object> message = new HashMap<>(2);
        message.put("msgtype", this.messageType.getValue());
        message.put("actionCard", cardMessage);
        return message;
    }

    /**
     * {@link  ActionCardMessage} builder
     */
    public static class ActionCardMessageBuilder implements Builder<ActionCardMessage> {
        private final ActionCardMessage message;

        /**
         * create {@link ActionCardMessageBuilder}
         *
         * @return this
         */
        public static ActionCardMessageBuilder builder() {
            return new ActionCardMessageBuilder();
        }

        public ActionCardMessageBuilder() {
            this(new ActionCardMessage());
        }

        public ActionCardMessageBuilder(ActionCardMessage message) {
            this.message = message;
        }

        /**
         * set {@link  ActionCardMessage} title
         *
         * @param title title
         * @return this
         * @see #setTitle(String)
         */
        public ActionCardMessageBuilder title(String title) {
            this.message.setTitle(title);
            return this;
        }

        /**
         * set {@link  ActionCardMessage} text
         *
         * @param text text
         * @return this
         * @see #setText(String)
         */
        public ActionCardMessageBuilder text(String text) {
            this.message.setText(text);
            return this;
        }

        /**
         * set {@link  ActionCardMessage} btnOrientation
         *
         * @param type btnOrientation
         * @return this
         * @see #setBtnOrientation(ButtonOrientationType)
         */
        public ActionCardMessageBuilder btnOrientation(ButtonOrientationType type) {
            this.message.setBtnOrientation(type);
            return this;
        }

        /**
         * set {@link  ActionCardMessage} btns
         *
         * @param buttons actionCardButton
         * @return this
         * @see #setBtns(List)
         */
        public ActionCardMessageBuilder btns(List<ActionCardButton> buttons) {
            this.message.setBtns(buttons);
            return this;
        }
        /**
         * set {@link  ActionCardMessage} btns
         *
         * @param buttons actionCardButton
         * @return this
         * @see #setBtns(List)
         */
        public ActionCardMessageBuilder btns(ActionCardButton... buttons) {
            return btns(Arrays.asList(buttons));
        }
        /**
         * add {@link  ActionCardMessage} btns
         *
         * @param buttons actionCardButton
         * @return this
         * @see #setBtns(List)
         */
        public ActionCardMessageBuilder addBtn(List<ActionCardButton> buttons) {
            List<ActionCardButton> list = this.message.getBtns();
            if (null == list) {
                list = new ArrayList<>(buttons.size());
            }
            list.addAll(buttons);
            this.message.setBtns(list);
            return this;
        }
        /**
         * add {@link  ActionCardMessage} btns
         *
         * @param buttons actionCardButton
         * @return this
         * @see #setBtns(List)
         */
        public ActionCardMessageBuilder addBtn(ActionCardButton... buttons) {
            return addBtn(Arrays.asList(buttons));
        }

        @Override
        public ActionCardMessage build() {
            return this.message;
        }
    }
}
