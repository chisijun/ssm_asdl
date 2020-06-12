package org.study.asdl.service;

import com.github.pagehelper.PageInfo;
import org.study.asdl.base.IService;
import org.study.asdl.model.domain.Log;
import org.study.asdl.model.dto.LockQueryDto;

public interface LogService extends IService<Log> {

    /**
     * query list with page
     *
     * @param lockQueryDto
     *
     * @return
     */
    PageInfo queryListWithPage(LockQueryDto lockQueryDto);
}
