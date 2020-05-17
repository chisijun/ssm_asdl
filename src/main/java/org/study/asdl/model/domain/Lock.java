package org.study.asdl.model.domain;

import lombok.Data;
import org.study.asdl.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_lock")
public class Lock extends BaseEntity {

    /**
     * 门锁名称
     */
    @Column(name = "lock_name")
    private String lockName;

    /**
     * 门锁编号
     */
    @Column(name = "lock_no")
    private String lockNo;

    /**
     * 门锁型号
     */
    private String model;

    /**
     * 供应商名称
     */
    private String provider;

    /**
     * 软件版本
     */
    @Column(name = "software_version")
    private String softwareVersion;

    /**
     * 硬件版本
     */
    @Column(name = "hardware_version")
    private String hardwareVersion;

    /**
     * 出厂日期
     */
    @Column(name = "factory_date")
    private String factoryDate;

    /**
     * 是否上锁 0-未上锁 1-已上锁
     */
    @Column(name = "is_lock")
    private Integer isLock;

    /**
     * 是否在线 0-不在线 1-在线
     */
    @Column(name = "is_online")
    private Integer isOnline;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;
}