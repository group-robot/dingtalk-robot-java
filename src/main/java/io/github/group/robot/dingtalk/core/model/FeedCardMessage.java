package io.github.group.robot.dingtalk.core.model;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.collection.CollectionUtil;
import io.github.group.robot.dingtalk.core.type.MessageType;
import io.github.group.robot.dingtalk.core.exception.DingTalkRobotException;
import io.github.group.robot.dingtalk.core.model.internal.Link;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FeedCard message
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
public class FeedCardMessage extends BaseMessage {
    /**
     * link
     *
     * @see Link
     */
    private List<Link> links;

    @Override
    protected void init() {
        this.messageType = MessageType.FEED_CARD;
    }

    @Override
    protected MessageType getType() {
        return this.messageType;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (CollectionUtil.isEmpty(this.links)) {
            throw new DingTalkRobotException("params validate missing");
        }
        List<Map<String, Object>> linkList = new ArrayList<>(this.links.size());
        for (Link link : this.links) {
            linkList.add(link.toMessageMap());
        }
        Map<String, Object> linkMessage = new HashMap<>(1);
        linkMessage.put("links", linkList);
        Map<String, Object> message = new HashMap<>(2);
        message.put("msgtype", this.messageType.getValue());
        message.put("feedCard", linkMessage);
        return message;
    }

    /**
     * {@link  FeedCardMessage} builder
     */
    public static class FeedCardMessageBuilder implements Builder<FeedCardMessage> {
        private final FeedCardMessage message;

        /**
         * create {@link FeedCardMessageBuilder}
         *
         * @return this
         */
        public static FeedCardMessageBuilder builder() {
            return new FeedCardMessageBuilder();
        }

        public FeedCardMessageBuilder() {
            this(new FeedCardMessage());
        }

        public FeedCardMessageBuilder(FeedCardMessage message) {
            this.message = message;
        }

        /**
         * set feedCard message links
         *
         * @param links links
         * @return this
         * @see #setLinks(List)
         */
        public FeedCardMessageBuilder links(List<Link> links) {
            this.message.setLinks(links);
            return this;
        }

        /**
         * set feedCard message links
         *
         * @param links links
         * @return this
         * @see #setLinks(List)
         */
        public FeedCardMessageBuilder links(Link... links) {
            return links(Arrays.asList(links));
        }

        /**
         * add feedCard message link
         *
         * @param links links
         * @return this
         * @see #setLinks(List)
         */
        public FeedCardMessageBuilder addLink(List<Link> links) {
            List<Link> list = this.message.getLinks();
            if (null == list) {
                list = new ArrayList<>(links.size());
            }
            list.addAll(links);
            this.message.setLinks(list);
            return this;
        }
        /**
         * add feedCard message link
         *
         * @param links links
         * @return this
         * @see #setLinks(List)
         */

        public FeedCardMessageBuilder addLink(Link... links) {
            return addLink(Arrays.asList(links));
        }

        @Override
        public FeedCardMessage build() {
            return this.message;
        }
    }
}
