package org.study.asdl.netty.entity;

import lombok.Data;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2019-08-04 14:39
 * @Description:
 */
@Data
public class RelayCmdStachEntity extends RelayCmdEntity {

    private static String cmd = "STACH";

    private String deviceNo;

    // 输出继电器(DO)通道
    // 0     所有通道
    // 1-16  1-16通道
    private int n;

    // 继电器状态
    // 0 - 松开
    // 1 - 吸和
    private int sta;

    // 延时时间 单位 秒
    // 0 - 99999 继电器状态切换延时
    // 100000    状态锁定（不切换）
    private int time;

    public static String buildCmdQuery() {

        return head + "+" + cmd + "=" + "?" + "\r\n";
    }

    // AT+STACH1=1<LF>
    public static String buildCmdSet(int n, int sta) {

        return head + "+" + cmd + n + "=" + sta + "\r\n";
    }
}
