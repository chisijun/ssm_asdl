package org.study.asdl.service;

import com.github.pagehelper.PageInfo;
import org.study.asdl.base.IService;
import org.study.asdl.model.domain.Lock;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.LockQueryDto;

public interface LockService extends IService<Lock> {

    /**
     * save lock
     *
     * @param lock
     * @param login
     *
     * @return
     */
    Integer saveLock(Lock lock, User login);

    /**
     * delete lock by id
     *
     * @param id
     *
     * @return
     */
    Integer deleteLockById(Long id);

    /**
     * query lock list with page
     *
     * @param lockQueryDto
     *
     * @return
     */
    PageInfo queryListWithPage(LockQueryDto lockQueryDto);
}
