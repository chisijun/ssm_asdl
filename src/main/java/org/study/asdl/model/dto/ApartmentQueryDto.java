package org.study.asdl.model.dto;

import lombok.Data;
import org.study.asdl.base.BaseQuery;

@Data
public class ApartmentQueryDto extends BaseQuery {

    /**
     * 公寓名称
     */
    private String apartmentName;

}
