package io.github.group.robot.dingtalk.core.model.internal;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.collection.CollectionUtil;
import io.github.group.robot.dingtalk.core.model.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * at 结构
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/8/12
 */
@Getter
@Setter
public class AtMessage implements Message {
    /**
     * 是否@所有人
     * <p>是否必填: 否</p>
     */
    private Boolean atAll;
    /**
     * 被@人的手机号
     */
    private List<String> atMobiles;
    /**
     * 被@人的用户userid
     */
    private List<String> atUserIds;

    @Override
    public Map<String, Object> toMessageMap() {
        Map<String, Object> message = new HashMap<>(3);
        if (CollectionUtil.isNotEmpty(this.atMobiles)) {
            message.put("atMobiles", this.atMobiles);
        }
        if (CollectionUtil.isNotEmpty(this.atUserIds)) {
            message.put("atUserIds", this.atUserIds);
        }
        message.put("isAtAll", null != this.atAll && this.atAll);
        return message;
    }

    /**
     * {@link  AtMessage} builder
     */
    public static class AtMessageBuilder implements Builder<AtMessage> {
        private final AtMessage message;

        /**
         * create {@link  AtMessageBuilder}
         *
         * @return this
         */
        public static AtMessageBuilder builder() {
            return new AtMessageBuilder();
        }

        public AtMessageBuilder() {
            this(new AtMessage());
        }

        public AtMessageBuilder(AtMessage message) {
            this.message = message;
        }

        /**
         * set  message at all
         *
         * @param atAll at all
         * @return this
         * @see #setAtAll(Boolean)
         */
        public AtMessageBuilder atAll(boolean atAll) {
            this.message.setAtAll(atAll);
            return this;
        }


        /**
         * set  message at mobiles
         *
         * @param atMobiles at mobiles
         * @return this
         * @see #setAtMobiles(List)
         */
        public AtMessageBuilder atMobiles(String... atMobiles) {
            return atMobiles(Arrays.asList(atMobiles));
        }

        /**
         * set  message at mobiles
         *
         * @param atMobiles at mobiles
         * @return this
         * @see #setAtMobiles(List)
         */
        public AtMessageBuilder atMobiles(List<String> atMobiles) {
            this.message.setAtMobiles(atMobiles);
            return this;
        }

        /**
         * add  message at mobile
         *
         * @param atMobile at mobile
         * @return this
         * @see #setAtMobiles(List)
         */
        public AtMessageBuilder addMobile(String atMobile) {
            return addMobiles(atMobile);
        }

        /**
         * add message at mobiles
         *
         * @param atMobiles at mobiles
         * @return this
         * @see #setAtMobiles(List)
         */
        public AtMessageBuilder addMobiles(String... atMobiles) {
            List<String> mobiles = this.message.getAtMobiles();
            if (null == mobiles) {
                mobiles = new ArrayList<>(atMobiles.length);
            }
            mobiles.addAll(Arrays.asList(atMobiles));
            this.message.setAtMobiles(mobiles);
            return this;
        }


        /**
         * set  message at userIds
         *
         * @param atUserIds at userIds
         * @return this
         * @see #setAtUserIds(List)
         */
        public AtMessageBuilder atUserIds(String... atUserIds) {
            return atUserIds(Arrays.asList(atUserIds));
        }

        /**
         * set  message  at userIds
         *
         * @param atUserIds at userIds
         * @return this
         * @see #setAtUserIds(List)
         */
        public AtMessageBuilder atUserIds(List<String> atUserIds) {
            this.message.setAtUserIds(atUserIds);
            return this;
        }

        /**
         * add  message  at userId
         *
         * @param atUserId at userId
         * @return this
         * @see #setAtUserIds(List)
         */
        public AtMessageBuilder addAtUserId(String atUserId) {
            return addAtUserIds(atUserId);
        }

        /**
         * add  message  at userIds
         *
         * @param atUserIds at userIds
         * @return this
         * @see #setAtUserIds(List)
         */
        public AtMessageBuilder addAtUserIds(String... atUserIds) {
            List<String> userIds = this.message.getAtUserIds();
            if (null == userIds) {
                userIds = new ArrayList<>(atUserIds.length);
            }
            userIds.addAll(Arrays.asList(atUserIds));
            this.message.setAtUserIds(userIds);
            return this;
        }

        @Override
        public AtMessage build() {
            return this.message;
        }
    }
}
