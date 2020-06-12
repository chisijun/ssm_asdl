package org.study.asdl.service;

import com.github.pagehelper.PageInfo;
import org.study.asdl.base.IService;
import org.study.asdl.model.domain.Room;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.RoomQueryDto;

public interface RoomService extends IService<Room> {

    /**
     * save room
     *
     * @param room
     * @param login
     *
     * @return
     */
    Integer saveRoom(Room room, User login);

    /**
     * delete room by id
     *
     * @param id
     *
     * @return
     */
    Integer deleteRoomById(Long id);

    /**
     * query room list with page
     *
     * @param roomQueryDto
     *
     * @return
     */
    PageInfo queryListWithPage(RoomQueryDto roomQueryDto);

    PageInfo queryCheckListWithPage(RoomQueryDto roomQueryDto);

    Integer openDoor(User login, Long roomId);
}
