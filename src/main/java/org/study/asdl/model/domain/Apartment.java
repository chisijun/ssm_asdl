package org.study.asdl.model.domain;

import lombok.Data;
import org.study.asdl.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "t_apartment")
public class Apartment extends BaseEntity {

    /**
     * 公寓名称
     */
    @Column(name = "apartment_name")
    private String apartmentName;

    /**
     * 公寓编号
     */
    @Column(name = "apartment_no")
    private String apartmentNo;

    /**
     * 位置
     */
    private String area;

    /**
     * 楼层数量
     */
    @Column(name = "floor_number")
    private Integer floorNumber;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

}