package org.study.asdl.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_cmd")
public class Cmd {
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
     * 门锁ID
     */
    @Column(name = "lock_id")
    private Long lockId;

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
     * 获取门锁ID
     *
     * @return lock_id - 门锁ID
     */
    public Long getLockId() {
        return lockId;
    }

    /**
     * 设置门锁ID
     *
     * @param lockId 门锁ID
     */
    public void setLockId(Long lockId) {
        this.lockId = lockId;
    }

    /**
     * 获取指令内容
     *
     * @return content - 指令内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置指令内容
     *
     * @param content 指令内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取发送时间
     *
     * @return send_date - 发送时间
     */
    public String getSendDate() {
        return sendDate;
    }

    /**
     * 设置发送时间
     *
     * @param sendDate 发送时间
     */
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * 获取回调时间
     *
     * @return call_back_date - 回调时间
     */
    public String getCallBackDate() {
        return callBackDate;
    }

    /**
     * 设置回调时间
     *
     * @param callBackDate 回调时间
     */
    public void setCallBackDate(String callBackDate) {
        this.callBackDate = callBackDate;
    }

    /**
     * 获取发送状态 0-失败 1-成功 2-超时
     *
     * @return is_send - 发送状态 0-失败 1-成功 2-超时
     */
    public Integer getIsSend() {
        return isSend;
    }

    /**
     * 设置发送状态 0-失败 1-成功 2-超时
     *
     * @param isSend 发送状态 0-失败 1-成功 2-超时
     */
    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
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