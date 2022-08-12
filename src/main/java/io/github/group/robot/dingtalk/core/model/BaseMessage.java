package io.github.group.robot.dingtalk.core.model;

import io.github.group.robot.dingtalk.core.type.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 请求消息的抽象类
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
public abstract class BaseMessage implements Message {
    protected MessageType messageType;

    protected void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public BaseMessage() {
        init();
    }

    /**
     * 初始化message
     */
    protected abstract void init();

    /**
     * 获取当前类型
     *
     * @return {@link  MessageType}
     */
    protected abstract MessageType getType();

    /**
     * 返回Message对象组装出来的Map对象，供后续JSON序列化
     *
     * @return Map
     */
    public abstract Map<String, Object> toMessageMap();

}
