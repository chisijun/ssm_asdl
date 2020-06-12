package org.study.asdl.model.dto;

import lombok.Data;
import org.study.asdl.base.BaseQuery;

@Data
public class LockQueryDto extends BaseQuery {

    /**
     * 门锁编号
     */
    private String lockNo;

}
