package org.study.asdl.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.study.asdl.netty.entity.RelayCmdStachEntity;
import org.study.asdl.netty.entity.RelayCmdWidEntity;
import org.study.asdl.netty.entity.RelayConstant;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2019-08-22 20:27
 * @Description: relay message handler
 */
@Data
@Slf4j
@Component
public class RelayMessageHandler {

    /**
     * 处理网络继电器消息
     *
     * @param ctx   the channel handler context
     * @param data  the relay message
     */
    public void handler(ChannelHandlerContext ctx, String data) {

        // 获取消息类型
        String type = RelayMessageDecoder.getMessageType(data);
        if (type == null) {
            return;
        }

        switch (type) {
            case "OK":
                // 设置成功
                break;
            case "WID":
                // 查询设备编号
                RelayCmdWidEntity relayCmdWidEntity = RelayCmdWidEntity.parse(data);
                String deviceNo = relayCmdWidEntity.getDeviceNo();
                log.info("# relay device no...[{}]", deviceNo);
                RelayConstant.RELAY_CHANNEL_MAP.put(relayCmdWidEntity.getDeviceNo(), ctx.channel());
                break;
        }
    }

    /**
     * 设置继电器状态
     *
     * @param deviceNo  设备编号
     * @param n         通道
     * @param sta       状态
     */
    public void setStach(String deviceNo, int n, int sta) {

        // 判断设备是否在线
        Channel channel = RelayConstant.RELAY_CHANNEL_MAP.get(deviceNo);
        if (channel == null) {
            throw new RuntimeException("===> relay device no [" + deviceNo + "] 设备尚未接入.");
        }

        if (!channel.isActive()) {
            throw new RuntimeException("===> relay device no [" + deviceNo + "] 设备不在线.");
        }

        // 下发指令
        String cmd = RelayCmdStachEntity.buildCmdSet(n, sta);

        // 发送数据
        log.info("===> relay device no [{}] cmd [{}]", deviceNo, cmd);
        channel.writeAndFlush(Unpooled.copiedBuffer(cmd, CharsetUtil.UTF_8));
    }

    /**
     * 设置继电器状态
     *
     * @param relayCmdStachEntity   the realy cmd stach entity
     */
    public void setStach(RelayCmdStachEntity relayCmdStachEntity) {

        setStach(relayCmdStachEntity.getDeviceNo(), relayCmdStachEntity.getN(), relayCmdStachEntity.getSta());
    }
}
