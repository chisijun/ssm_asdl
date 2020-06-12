package org.study.asdl.dao;

import org.study.asdl.model.domain.Room;
import org.study.asdl.model.dto.RoomQueryDto;
import org.study.asdl.model.vo.RoomVo;
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
    List<RoomVo> queryListWithPage(RoomQueryDto roomQueryDto);

    List<RoomVo> queryCheckListWithPage(RoomQueryDto roomQueryDto);
}