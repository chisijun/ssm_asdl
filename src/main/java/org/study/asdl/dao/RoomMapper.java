package org.study.asdl.dao;

import org.study.asdl.model.domain.Room;
import org.study.asdl.model.dto.RoomQueryDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomMapper extends Mapper<Room> {

    /**
     * query room list with page
     *
     * @param roomQueryDto  the room query dto
     *
     * @return  the list.
     */
    List<Room> queryListWithPage(RoomQueryDto roomQueryDto);
}