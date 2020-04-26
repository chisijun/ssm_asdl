package org.study.asdl.netty.entity;

import lombok.Data;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2019-08-04 14:59
 * @Description: 查询、设置设备Id命令
 */
@Data
public class RelayCmdWidEntity extends RelayCmdEntity {

    private static String cmd = "WID";

    // 设备编号
    private String deviceNo;

    public static String buildCmdQuery() {

        return head + "+" + cmd + "=" + "?" + "\r\n";
    }

    public static String buildCmdSet(String deviceNo) {

        return head + "+" + cmd + "=" + deviceNo + "\r\n";
    }

    public static RelayCmdWidEntity parse(String received) {

        int end_index = received.indexOf("\r\n");
        System.out.println("end_index = " + end_index);

        RelayCmdWidEntity relayCmdWidEntity = new RelayCmdWidEntity();
        relayCmdWidEntity.setDeviceNo(received.substring(5, end_index));

        return relayCmdWidEntity;
    }
}
