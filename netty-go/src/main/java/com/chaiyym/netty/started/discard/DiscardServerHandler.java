package com.chaiyym.netty.started.discard;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 接受到任何的数据都不会响应
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		ByteBuf in = (ByteBuf) msg;
//		in.release();
//		try {
//			while (in.isReadable()) { // (1)
//				System.out.print((char) in.readByte());
//				System.out.flush();
//			}
//		} finally {
//			ReferenceCountUtil.release(msg); // (2)
//		}
		
		ctx.write(msg); // (1)
		ctx.flush(); // (2)
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
