package org.study.asdl.model.domain;

import lombok.Data;
import org.study.asdl.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_cmd")
public class Cmd extends BaseEntity {

    /**
     * 门锁ID
     */
    @Column(name = "lock_id")
    private Long lockId;

    /**
     * 门锁ID
     */
    @Column(name = "lock_no")
    private String lockNo;

    /**
     * 指令内容
     */
    private String content;

    /**
     * 发送时间
     */
    @Column(name = "send_date")
    private String sendDate;

    /**
     * 回调时间
     */
    @Column(name = "call_back_date")
    private String callBackDate;

    /**
     * 发送状态 0-失败 1-成功 2-超时
     */
    @Column(name = "is_send")
    private Integer isSend;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;
}