package org.study.asdl.model.dto;

import lombok.Data;
import org.study.asdl.base.BaseQuery;

@Data
public class RoomQueryDto extends BaseQuery {

    /**
     * 房间编号
     */
    private String roomNo;

    private String lockNo;

    private String mobileNo;
}
