package org.study.asdl.model.domain;

import lombok.Data;
import org.study.asdl.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "t_order")
public class Order extends BaseEntity {

    /**
     * 角色编码
     */
    @Column(name = "room_id")
    private Integer roomId;

    /**
     * 角色编码
     */
    @Column(name = "room_no")
    private String roomNo;

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

}