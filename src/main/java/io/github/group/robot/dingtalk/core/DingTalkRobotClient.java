package io.github.group.robot.dingtalk.core;

import cn.hutool.core.util.StrUtil;
import com.hb0730.https.SimpleHttp;
import com.hb0730.https.support.SimpleHttpResponse;
import com.hb0730.https.utils.StringUtils;
import com.hb0730.jsons.SimpleJsonProxy;
import io.github.group.robot.dingtalk.core.exception.DingTalkRobotException;
import io.github.group.robot.dingtalk.core.model.BaseMessage;
import io.github.group.robot.dingtalk.core.model.DingTalkRobotResponse;
import lombok.Getter;
import lombok.Setter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 钉钉机器人客户端
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
public class DingTalkRobotClient {
    /**
     * dingtalk robot webhook
     */
    @Getter
    @Setter
    private String webhook;
    /**
     * dingtalk robot secret
     */
    @Getter
    @Setter
    private String secret;

    public DingTalkRobotClient() {
    }

    public DingTalkRobotClient(String webhook, String secret) {
        this.webhook = webhook;
        this.secret = secret;
    }


    /**
     * send message
     *
     * @param message message
     * @return response
     * @throws DingTalkRobotException .
     */
    public DingTalkRobotResponse sendMessage(BaseMessage message) {
        if (null == message) {
            throw new DingTalkRobotException("message missing");
        }
        String json = SimpleJsonProxy.json.toJson(message.toMessageMap());
        return sendMessage(json);
    }

    /**
     * send message
     *
     * @param json json message
     * @return response
     */
    public DingTalkRobotResponse sendMessage(String json) {
        if (StrUtil.isBlank(json)) {
            throw new DingTalkRobotException("message missing");
        }
        SimpleHttpResponse response = SimpleHttp.HTTP.post(url(), json);
        if (response.isSuccess()) {
            return SimpleJsonProxy.json.fromJson(response.getBodyStr(), DingTalkRobotResponse.class);
        }
        throw new DingTalkRobotException("send message failed");
    }

    /**
     * send message
     *
     * @param url     webhook
     * @param message message
     * @return response
     */
    public DingTalkRobotResponse sendMessage(String url, BaseMessage message) {
        if (null == message) {
            throw new DingTalkRobotException("message missing");
        }
        String json = SimpleJsonProxy.json.toJson(message.toMessageMap());
        return sendMessage(url, json);
    }

    /**
     * send message
     *
     * @param url  webhook
     * @param json json message
     * @return response
     */
    public DingTalkRobotResponse sendMessage(String url, String json) {
        if (StrUtil.isBlank(json)) {
            throw new DingTalkRobotException("message missing");
        }
        if (StrUtil.isBlank(url)) {
            throw new DingTalkRobotException("url missing");
        }
        SimpleHttpResponse response = SimpleHttp.HTTP.post(url, json);
        if (response.isSuccess()) {
            return SimpleJsonProxy.json.fromJson(response.getBodyStr(), DingTalkRobotResponse.class);
        }
        throw new DingTalkRobotException("send message failed");
    }


    protected String url() {
        if (StringUtils.isBlank(this.webhook)) {
            throw new DingTalkRobotException("webhok is null");
        }
        if (StringUtils.isBlank(secret)) {
            return this.webhook;
        }
        long timestamp = System.currentTimeMillis();
        String sign = sign(timestamp, secret);
        return webhook + "&timestamp=" + timestamp + "&sign=" + sign;
    }

    protected String sign(Long timestamp, String appSecret) {
        if (StrUtil.isBlank(appSecret)) {
            throw new DingTalkRobotException("app secret missing");
        }
        String stringToSign = timestamp + "\n" + appSecret;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(appSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            Base64.Encoder encoder = Base64.getEncoder();
            return new String(encoder.encode(signData), StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new DingTalkRobotException("sign error", e);
        }
    }

}
