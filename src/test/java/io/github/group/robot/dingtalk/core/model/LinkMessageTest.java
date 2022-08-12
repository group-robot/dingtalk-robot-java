package io.github.group.robot.dingtalk.core.model;

import org.junit.jupiter.api.Test;

class LinkMessageTest extends DingTalkMessageTest {

    @Test
    void sendMessage() {
        LinkMessage message = LinkMessage.LinkMessageBuilder.builder()
            .text("这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林")
            .title("时代的火车向前开")
            .messageUrl("https://www.dingtalk.com/s?__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI")
            .build();
        sendMessage(message);
    }
}
