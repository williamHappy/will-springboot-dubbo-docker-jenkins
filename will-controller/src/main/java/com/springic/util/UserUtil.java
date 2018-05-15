package com.springic.util;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.springic.entity.user.UserEntity;
import com.springic.exception.CommonBizException;
import com.springic.exception.ExpCodeEnum;
import com.springic.redis.RedisServiceTemp;
import com.springic.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author will
 * @date 2017/11/9 下午10:24
 *
 * @description 用户信息工具包
 */
@Component
public class UserUtil {

    /** HTTP Response中Session ID 的名字 */
    @Value("${session.SessionIdName}")
    private String sessionIdName;

    @Reference(version = "1.0.0")
    private RedisService redisService;



    /**
     * 获取用户信息
     * @param httpServletReq HTTP请求
     * @return 用户信息
     */
    public UserEntity getUser(HttpServletRequest httpServletReq) {
        // 获取SessionID
        String sessionID = getSessionID(httpServletReq);
        if (StringUtils.isEmpty(sessionID)) {
            throw new CommonBizException(ExpCodeEnum.SESSION_NULL);
        }

        // 获取UserEntity
//        Object userEntity =  redisService.get(sessionID);
        // TODO 暂时使用本地redis
        Object userEntity = RedisServiceTemp.userMap.get(sessionID);
        if (userEntity == null) {
            return null;
        }
        return (UserEntity) userEntity;

    }

    /**
     * 获取SessionID
     * @param request 当前的请求对象
     * @return SessionID的值
     */
    private String getSessionID(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        // 遍历所有cookie，找出SessionID
        String sessionID = null;
        if (cookies!=null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                if (sessionIdName.equals(cookie.getName())) {
                    sessionID = cookie.getValue();
                    break;
                }
            }
        }

        return sessionID;
    }
}
