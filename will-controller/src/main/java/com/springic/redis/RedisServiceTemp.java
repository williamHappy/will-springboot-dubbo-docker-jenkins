package com.springic.redis;

import com.google.common.collect.Maps;
import com.springic.entity.user.AccessAuthEntity;
import com.springic.entity.user.UserEntity;

import java.util.Map;

/**
 * @author will
 * @date 2017/11/14 下午2:57
 * @description
 */
public class RedisServiceTemp {

    public static Map<String, AccessAuthEntity> accessAuthMap = Maps.newHashMap();

    public static Map<String, UserEntity> userMap = Maps.newHashMap();
}
