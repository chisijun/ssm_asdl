package org.study.asdl.model.domain;

import lombok.Data;
import org.study.asdl.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "t_room")
public class Room extends BaseEntity {

    /**
     * 公寓ID
     */
    @Column(name = "apartment_id")
    private Long apartmentId;

    /**
     * 房间编号
     */
    @Column(name = "room_no")
    private String roomNo;

    /**
     * 房间名称
     */
    @Column(name = "room_name")
    private String roomName;

    /**
     * 所属楼层
     */
    @Column(name = "floor_no")
    private Integer floorNo;

    /**
     * 价格 单位-元保留两位小数
     */
    private BigDecimal price;

    /**
     * 可住人数
     */
    @Column(name = "people_number")
    private Integer peopleNumber;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

}