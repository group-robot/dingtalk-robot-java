package io.github.group.robot.dingtalk.core.model.internal;

import io.github.group.robot.dingtalk.core.model.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 跳转卡片中的按钮实体类
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionCardButton implements Message {
    /**
     * 按钮标题
     */
    private String title;
    /**
     * 实际点击时调用的URL
     */
    private String actionUrl;

    @Override
    public Map<String, Object> toMessageMap() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("title", this.title);
        message.put("actionURL", this.actionUrl);
        return message;
    }
}
