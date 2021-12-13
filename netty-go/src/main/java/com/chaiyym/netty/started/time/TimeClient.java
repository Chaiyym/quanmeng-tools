package com.chaiyym.netty.started.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeClient {
	public static void main(String[] args) {
		String host=args[0];
		int port = Integer.parseInt(args[1]);
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(workGroup);
			b.channel(NioServerSocketChannel.class);
			b.option(ChannelOption.SO_KEEPALIVE,true);
			b.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new TimeServerHandler());
				}
			});
			ChannelFuture f = b.connect(host, port).sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workGroup.shutdownGracefully();
		}
	}
}
