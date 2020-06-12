package org.study.asdl.model.domain;

import lombok.Data;
import org.study.asdl.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_log")
public class Log extends BaseEntity {

    /**
     * 门锁ID
     */
    @Column(name = "lock_id")
    private Long lockId;

    /**
     * 门锁编号
     */
    @Column(name = "lock_no")
    private String lockNo;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_no")
    private String roomNo;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;
}