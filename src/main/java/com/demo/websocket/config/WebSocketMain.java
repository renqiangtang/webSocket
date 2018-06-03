package com.demo.websocket.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.logging.Logger;


/**
 * @date 2018-06-03
 * @author sky
 * @description   程序的应用，负责启动应用
 */
public class WebSocketMain {
    private static Logger logger = Logger.getLogger("WebSocketMain");

    public static void main(String[] args) {
        EventLoopGroup bossGroup  = new NioEventLoopGroup();
        EventLoopGroup workGroup  = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new MyWebSocketChannelHandler());
            logger.info("服务端开启等待客户端连接...");
            Channel ch  = bootstrap.bind(8888).sync().channel();
            ch.closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //优雅的推出程序
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
