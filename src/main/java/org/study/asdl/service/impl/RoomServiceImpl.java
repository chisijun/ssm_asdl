package org.study.asdl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.dao.LockRoomMapper;
import org.study.asdl.dao.RoomMapper;
import org.study.asdl.model.domain.*;
import org.study.asdl.model.dto.RoomQueryDto;
import org.study.asdl.model.vo.RoomVo;
import org.study.asdl.service.CmdService;
import org.study.asdl.service.LockService;
import org.study.asdl.service.LogService;
import org.study.asdl.service.RoomService;
import org.study.asdl.utils.TimeUtils;

import javax.annotation.Resource;
import java.util.List;

@Service("roomService")
public class RoomServiceImpl extends BaseService<Room> implements RoomService {

    @Resource
    private RoomMapper roomMapper;
    @Resource
    private LockRoomMapper lockRoomMapper;
    @Resource
    private LogService logService;
    @Resource
    private CmdService cmdService;
    @Resource
    private LockService lockService;

    @Override
    public Integer saveRoom(Room room, User login) {

        room.setUpdateInfo(login);

        if (room.isNew()) {

            return roomMapper.insertSelective(room);
        } else {

            return roomMapper.updateByPrimaryKeySelective(room);
        }

    }

    @Override
    public Integer deleteRoomById(Long id) {

        // 判断是否有人入住

        // 判断是否已经绑定门锁


        return roomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo queryListWithPage(RoomQueryDto roomQueryDto) {

        PageHelper.startPage(roomQueryDto.getPageNum(), roomQueryDto.getPageSize());

        List<RoomVo> roomVoList = roomMapper.queryListWithPage(roomQueryDto);

        return new PageInfo<>(roomVoList);
    }

    @Override
    public PageInfo queryCheckListWithPage(RoomQueryDto roomQueryDto) {

        List<RoomVo> roomVoList = roomMapper.queryCheckListWithPage(roomQueryDto);

        return new PageInfo<>(roomVoList);

    }

    @Override
    public Integer openDoor(User login, Long roomId) {

        LockRoom lockRoom = new LockRoom();
        lockRoom.setRoomId(roomId);
        lockRoom = lockRoomMapper.selectOne(lockRoom);

        Lock lock = lockService.selectByKey(lockRoom.getLockId());
        Room room = roomMapper.selectByPrimaryKey(roomId);

        Log log = new Log();
        Cmd cmd = new Cmd();

        log.setLockId(lock.getId());
        log.setLockNo(lock.getLockNo());
        log.setRoomId(roomId);
        log.setRoomNo(room.getRoomNo());
        log.setStatus("成功");
        log.setUpdateInfo(login);

        cmd.setContent("{\"msgType\":\"openDoorMsg\",\"lockNo\":\"" + lock.getLockNo() + "\"}");
        cmd.setSendDate(TimeUtils.getNowTimeR());
        cmd.setLockId(lock.getId());
        cmd.setLockNo(log.getLockNo());
        cmd.setIsSend(1);
        cmd.setUpdateInfo(login);

        Integer result = logService.save(log);
        result += cmdService.save(cmd);

        return result;
    }
}
