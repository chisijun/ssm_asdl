package org.study.asdl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.dao.RoomMapper;
import org.study.asdl.model.domain.Room;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.RoomQueryDto;
import org.study.asdl.service.RoomService;

import javax.annotation.Resource;
import java.util.List;

@Service("roomService")
public class RoomServiceImpl extends BaseService<Room> implements RoomService {

    @Resource
    private RoomMapper roomMapper;

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

        List<Room> roomList = roomMapper.queryListWithPage(roomQueryDto);

        return new PageInfo<>(roomList);
    }
}
