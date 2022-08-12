<h1 align="center"><a href="https://github.com/group-robot/java-dingtalk-robot" target="_blank">java-dingtalk-robot</a></h1>
<p align="center">
<a href="https://search.maven.org/artifact/io.github.group-robot/wrok-weixin-robot-core">
<img alt="Maven Central" src="https://img.shields.io/maven-central/v/io.github.group-robot/wrok-weixin-robot-core?style=flat-square">
</a>
<a href="https://github.com/group-robot/java-dingtalk-robot/blob/master/LICENSE">
<img alt="GitHub" src="https://img.shields.io/github/license/group-robot/java-dingtalk-robot?style=flat-square">
</a>
<a href="https://github.com/group-robot/java-dingtalk-robot/actions">
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/workflow/status/group-robot/java-dingtalk-robot/Tag%20Release?style=flat-square">
</a>
<a href="https://www.oracle.com/java/technologies/javase-downloads.html">
<img alt="jdk" src="https://img.shields.io/badge/jdk-8%2B-green?style=flat-square">
</a>
</p>

# java-dingtalk-robot

dingtalk robot java version

# maven

```xml

<dependency>
    <groupId>io.github.group-robot</groupId>
    <artifactId>dingtalk-robot-core</artifactId>
    <version>${version}</version>
</dependency>
```

# example

## text
```java
        TextMessage message = TextMessage.TextMessageBuilder.builder().at(
            AtMessage.AtMessageBuilder.builder()
                .atAll(true)
                .build()
        ).content("我就是我,不一样的烟火").build();
```

## link
```java
        LinkMessage message = LinkMessage.LinkMessageBuilder.builder()
            .text("这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林")
            .title("时代的火车向前开")
            .messageUrl("https://www.dingtalk.com/s?__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI")
            .build();
```

## markdown
```java
        MarkdownMessage message = MarkdownMessage.MarkdownMessageBuilder
            .builder()
            .at(
                AtMessage.AtMessageBuilder
                    .builder()
                    .atAll(true)
                    .build()
            )
            .title("杭州天气")
            .text("#### 杭州天气 @150XXXXXXXX \n > 9度，西北风1级，空气良89，相对温度73%\n > ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n > ###### 10点20分发布 [天气](https://www.dingtalk.com) \n")
            .build();
```

## action card
```java
        ActionCardMessage message = ActionCardMessage.ActionCardMessageBuilder.builder()
            .title("我 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身")
            .text("![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \n\n #### 乔布斯 20 年前想打造的苹果咖啡厅 \n\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划")
            .btnOrientation(ButtonOrientationType.VERTICAL)
            .addBtn(
                ActionCardButton.builder()
                    .title("内容不错")
                    .actionUrl("https://www.dingtalk.com/")
                    .build(),
                ActionCardButton.builder()
                    .title("不感兴趣")
                    .actionUrl("https://www.dingtalk.com/")
                    .build()
            ).build();
```

```java
SingleActionCardMessage message = SingleActionCardMessage.SingleActionCardMessageBuilder
            .builder()
            .title("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身")
            .text("![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png) \n" +
                " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n" +
                " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划")
            .btnOrientation(ButtonOrientationType.VERTICAL)
            .singleTitle("阅读全文")
            .singleUrl("https://www.dingtalk.com/")
            .build();
```

## feed card
```java
        FeedCardMessage message = FeedCardMessage.FeedCardMessageBuilder
            .builder()
            .addLink(
                Link.builder()
                    .title("时代的火车向前开1")
                    .messageUrl("https://www.dingtalk.com/")
                    .picUrl("https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.pn")
                    .build()
                ,
                Link.builder()
                    .title("时代的火车向前开2")
                    .messageUrl("https://www.dingtalk.com/")
                    .picUrl("https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png")
                    .build()
            ).build();
```

# send 
```java
        String json = "{\"msgtype\":\"actionCard\",\"actionCard\":{\"title\":\"我 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store " +
            "的前身\",\"text\":\"![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \\n\\n #### 乔布斯 20 年前想打造的苹果咖啡厅 \\n\\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划\",\"btnOrientation\":\"0\",\"btns\":[{\"title\":\"内容不错\",\"actionURL\":\"https://www.dingtalk.com/\"},{\"title\":\"不感兴趣\",\"actionURL\":\"https://www.dingtalk.com/\"}]}}";
        DingTalkRobotClient client = new DingTalkRobotClient(System.getenv("webhook"), System.getenv("secret"));
        DingTalkRobotResponse response = client.sendMessage(json);
```