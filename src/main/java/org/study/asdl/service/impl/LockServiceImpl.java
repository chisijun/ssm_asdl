package org.study.asdl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.dao.LockMapper;
import org.study.asdl.dao.LockRoomMapper;
import org.study.asdl.model.domain.Lock;
import org.study.asdl.model.domain.LockRoom;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.LockQueryDto;
import org.study.asdl.service.LockService;

import javax.annotation.Resource;
import java.util.List;

@Service("lockService")
public class LockServiceImpl extends BaseService<Lock> implements LockService {

    @Resource
    private LockMapper lockMapper;
    @Resource
    private LockRoomMapper lockRoomMapper;

    @Override
    public Integer saveLock(Lock lock, User login) {

        lock.setUpdateInfo(login);

        if (lock.isNew()) {

            return lockMapper.insertSelective(lock);
        } else {

            return lockMapper.updateByPrimaryKey(lock);
        }
    }

    @Override
    public Integer deleteLockById(Long id) {

        // 判断是否在使用
        LockRoom lockRoom = new LockRoom();
        lockRoom.setLockId(id);
        int count = lockRoomMapper.selectCount(lockRoom);
        if (count > 0) {
            throw new RuntimeException("门锁已经绑定了房间");
        }

        return lockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo queryListWithPage(LockQueryDto lockQueryDto) {

        PageHelper.startPage(lockQueryDto.getPageNum(), lockQueryDto.getPageSize());

        List<Lock> lockList = lockMapper.queryListWithPage(lockQueryDto);

        return new PageInfo<>(lockList);
    }
}
