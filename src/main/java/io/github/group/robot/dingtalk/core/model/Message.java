package io.github.group.robot.dingtalk.core.model;

import java.util.Map;

/**
 * message 对象
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
public interface Message {
    /**
     * 返回Message对象组装出来的Map对象，供后续JSON序列化
     *
     * @return Map
     */
    Map<String, Object> toMessageMap();

    ;
}
