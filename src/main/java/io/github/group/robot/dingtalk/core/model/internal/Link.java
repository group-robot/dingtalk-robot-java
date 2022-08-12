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
 * link
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Link implements Message {
    /**
     * 单条信息文本
     * <p>是否必填: 是</p>
     */
    private String title;
    /**
     * 点击单条信息到跳转链接
     * <p>是否必填: 是</p>
     */
    private String messageUrl;
    /**
     * 单条信息后面图片的URL
     * <p>是否必填: 是</p>
     */
    private String picURL;

    @Override
    public Map<String, Object> toMessageMap() {
        Map<String, Object> message = new HashMap<>(3);
        message.put("title", this.title);
        message.put("messageURL", this.messageUrl);
        message.put("picURL", this.picURL);
        return message;
    }
}
