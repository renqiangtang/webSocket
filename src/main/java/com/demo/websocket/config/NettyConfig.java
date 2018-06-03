package com.demo.websocket.config;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @date 2018-06-03
 * @author sky
 * @description   存储整个工程的全局配置
 */
public class NettyConfig {
    /**
     * 存储每一个客户端进来时的channel 对象
     */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
