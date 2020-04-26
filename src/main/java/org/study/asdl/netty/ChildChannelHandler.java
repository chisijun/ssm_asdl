package org.study.asdl.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel e) throws Exception {

		// 解码器
		// 基于换行符号
//		e.pipeline().addLast(new LineBasedFrameDecoder(1024));
		// 基于指定字符串【换行符，这样功能等同于LineBasedFrameDecoder】
		// e.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false, Delimiters.lineDelimiter()));
		// 基于最大长度
		// e.pipeline().addLast(new FixedLengthFrameDecoder(4));
		// 解码转String
//		e.pipeline().addLast(new StringDecoder());
		// 编码器 String
//		e.pipeline().addLast(new StringEncoder());
		// 在管道中添加我们自己的接收数据实现方法
		e.pipeline().addLast(new MyServerHanlder());
		
	}
	
}
