package org.study.asdl.netty.entity;

import lombok.Data;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2019-08-04 15:01
 * @Description: 网络继电器命令
 */
@Data
public class RelayCmdEntity {

    public static String head = "AT";

    public static String cmd;
}
