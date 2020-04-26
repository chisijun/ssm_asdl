package org.study.asdl.netty;

import org.apache.commons.lang.StringUtils;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2019-08-22 21:08
 * @Description: the class relay message decoder
 */
public class RelayMessageDecoder {

    /**
     * get relay message type
     *
     * @param msg   the relay message
     *
     * @return  the message type
     */
    public static String getMessageType(String msg) {

        if (StringUtils.isEmpty(msg) || msg.length() < 2) {
            return null;
        }

        if (msg.startsWith("OK")) {
            return "OK";
        }

        int start_index = msg.indexOf('+');
        int end_index = msg.indexOf(':');

        if (end_index <= start_index) {
            return null;
        }

        return msg.substring(start_index + 1, end_index);
    }

}
