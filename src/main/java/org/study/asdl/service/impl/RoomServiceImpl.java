package org.study.asdl.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.model.domain.Room;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.RoomQueryDto;
import org.study.asdl.service.RoomService;

@Service("roomService")
public class RoomServiceImpl extends BaseService<Room> implements RoomService {

    @Override
    public Integer saveRoom(Room room, User login) {
        return null;
    }

    @Override
    public Integer deleteRoomById(Long id) {
        return null;
    }

    @Override
    public PageInfo queryListWithPage(RoomQueryDto roomQueryDto) {
        return null;
    }
}
