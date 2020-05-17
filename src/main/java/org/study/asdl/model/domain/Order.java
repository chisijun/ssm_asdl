package org.study.asdl.model.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order")
public class Order {
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
     * 角色编码
     */
    @Column(name = "room_id")
    private String roomId;

    /**
     * 顾客类型 0-散客 1-渠道 2-会员
     */
    @Column(name = "guest_type")
    private Integer guestType;

    /**
     * 顾客姓名
     */
    @Column(name = "guest_name")
    private String guestName;

    /**
     * 手机号码
     */
    @Column(name = "guest_mobile")
    private String guestMobile;

    /**
     * 身份证号码
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 入住时间
     */
    @Column(name = "check_in")
    private String checkIn;

    /**
     * 离店时间
     */
    @Column(name = "check_out")
    private String checkOut;

    /**
     * 价格 单位-元保留两位小数
     */
    private BigDecimal price;

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
     * 获取角色编码
     *
     * @return room_id - 角色编码
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * 设置角色编码
     *
     * @param roomId 角色编码
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取顾客类型 0-散客 1-渠道 2-会员
     *
     * @return guest_type - 顾客类型 0-散客 1-渠道 2-会员
     */
    public Integer getGuestType() {
        return guestType;
    }

    /**
     * 设置顾客类型 0-散客 1-渠道 2-会员
     *
     * @param guestType 顾客类型 0-散客 1-渠道 2-会员
     */
    public void setGuestType(Integer guestType) {
        this.guestType = guestType;
    }

    /**
     * 获取顾客姓名
     *
     * @return guest_name - 顾客姓名
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * 设置顾客姓名
     *
     * @param guestName 顾客姓名
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    /**
     * 获取手机号码
     *
     * @return guest_mobile - 手机号码
     */
    public String getGuestMobile() {
        return guestMobile;
    }

    /**
     * 设置手机号码
     *
     * @param guestMobile 手机号码
     */
    public void setGuestMobile(String guestMobile) {
        this.guestMobile = guestMobile;
    }

    /**
     * 获取身份证号码
     *
     * @return id_card - 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取入住时间
     *
     * @return check_in - 入住时间
     */
    public String getCheckIn() {
        return checkIn;
    }

    /**
     * 设置入住时间
     *
     * @param checkIn 入住时间
     */
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * 获取离店时间
     *
     * @return check_out - 离店时间
     */
    public String getCheckOut() {
        return checkOut;
    }

    /**
     * 设置离店时间
     *
     * @param checkOut 离店时间
     */
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * 获取价格 单位-元保留两位小数
     *
     * @return price - 价格 单位-元保留两位小数
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格 单位-元保留两位小数
     *
     * @param price 价格 单位-元保留两位小数
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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