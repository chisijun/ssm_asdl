package org.study.asdl.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_lock")
public class Lock {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 版本号
     */
    private Integer version;

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

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建人ID
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 最近操作人
     */
    @Column(name = "last_operator")
    private String lastOperator;

    /**
     * 最后操作人ID
     */
    @Column(name = "last_operator_id")
    private Long lastOperatorId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取门锁名称
     *
     * @return lock_name - 门锁名称
     */
    public String getLockName() {
        return lockName;
    }

    /**
     * 设置门锁名称
     *
     * @param lockName 门锁名称
     */
    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    /**
     * 获取门锁编号
     *
     * @return lock_no - 门锁编号
     */
    public String getLockNo() {
        return lockNo;
    }

    /**
     * 设置门锁编号
     *
     * @param lockNo 门锁编号
     */
    public void setLockNo(String lockNo) {
        this.lockNo = lockNo;
    }

    /**
     * 获取门锁型号
     *
     * @return model - 门锁型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置门锁型号
     *
     * @param model 门锁型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取供应商名称
     *
     * @return provider - 供应商名称
     */
    public String getProvider() {
        return provider;
    }

    /**
     * 设置供应商名称
     *
     * @param provider 供应商名称
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * 获取软件版本
     *
     * @return software_version - 软件版本
     */
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * 设置软件版本
     *
     * @param softwareVersion 软件版本
     */
    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    /**
     * 获取硬件版本
     *
     * @return hardware_version - 硬件版本
     */
    public String getHardwareVersion() {
        return hardwareVersion;
    }

    /**
     * 设置硬件版本
     *
     * @param hardwareVersion 硬件版本
     */
    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    /**
     * 获取出厂日期
     *
     * @return factory_date - 出厂日期
     */
    public String getFactoryDate() {
        return factoryDate;
    }

    /**
     * 设置出厂日期
     *
     * @param factoryDate 出厂日期
     */
    public void setFactoryDate(String factoryDate) {
        this.factoryDate = factoryDate;
    }

    /**
     * 获取是否上锁 0-未上锁 1-已上锁
     *
     * @return is_lock - 是否上锁 0-未上锁 1-已上锁
     */
    public Integer getIsLock() {
        return isLock;
    }

    /**
     * 设置是否上锁 0-未上锁 1-已上锁
     *
     * @param isLock 是否上锁 0-未上锁 1-已上锁
     */
    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    /**
     * 获取是否在线 0-不在线 1-在线
     *
     * @return is_online - 是否在线 0-不在线 1-在线
     */
    public Integer getIsOnline() {
        return isOnline;
    }

    /**
     * 设置是否在线 0-不在线 1-在线
     *
     * @param isOnline 是否在线 0-不在线 1-在线
     */
    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建人ID
     *
     * @return creator_id - 创建人ID
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人ID
     *
     * @param creatorId 创建人ID
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取最近操作人
     *
     * @return last_operator - 最近操作人
     */
    public String getLastOperator() {
        return lastOperator;
    }

    /**
     * 设置最近操作人
     *
     * @param lastOperator 最近操作人
     */
    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    /**
     * 获取最后操作人ID
     *
     * @return last_operator_id - 最后操作人ID
     */
    public Long getLastOperatorId() {
        return lastOperatorId;
    }

    /**
     * 设置最后操作人ID
     *
     * @param lastOperatorId 最后操作人ID
     */
    public void setLastOperatorId(Long lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}