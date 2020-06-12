package org.study.asdl.model.vo;

import lombok.Data;
import org.study.asdl.base.BaseVo;

import java.math.BigDecimal;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2020/6/12 22:35
 * @Description: TODO
 */
@Data
public class RoomVo extends BaseVo {

    private String guestName;

    private String checkIn;

    private String checkOut;

    /**
     * 公寓ID
     */
    private Long apartmentId;

    /**
     * 公寓名称
     */
    private String apartmentName;

    /**
     * 门锁编号
     */
    private String lockId;

    /**
     * 门锁编号
     */
    private String lockNo;

    /**
     * 房间编号
     */
    private String roomNo;

    /**
     * 房间名称
     */
    private String roomName;

    /**
     * 所属楼层
     */
    private Integer floorNo;

    /**
     * 价格 单位-元保留两位小数
     */
    private BigDecimal price;

    /**
     * 可住人数
     */
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
