package org.study.asdl.netty.entity;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2019-08-22 21:20
 * @Description:
 */
public class RelayConstant {

    // 设备-通道 map
    public static ConcurrentHashMap<String, Channel> RELAY_CHANNEL_MAP = new ConcurrentHashMap<>();

}
