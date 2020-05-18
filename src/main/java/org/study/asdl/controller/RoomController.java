package org.study.asdl.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.study.asdl.annotation.Authorization;
import org.study.asdl.annotation.CurrentUser;
import org.study.asdl.common.JsonResult;
import org.study.asdl.model.domain.Room;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.RoomQueryDto;
import org.study.asdl.service.RoomService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/room")
public class RoomController  {

    @Resource
    private RoomService roomService;

    /**
     * 保存公寓
     *
     * @param login
     * @param room
     * @return
     */
    @Authorization
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonResult saveRoom(@CurrentUser User login, Room room) {

        Integer result = roomService.saveRoom(room, login);
        if (result < 1) {
            return new JsonResult(false, "操作失败", result);
        }

        return new JsonResult(true, "操作成功", result);
    }

    /**
     * 删除用户
     */
    @Authorization
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
    public JsonResult deleteRoomById(@PathVariable Long id) {

        Integer result = roomService.deleteRoomById(id);
        if (result < 1) {
            return new JsonResult(false, "操作失败", result);
        }

        return new JsonResult(true, "操作成功", result);
    }

    @Authorization
    @RequestMapping(value = "/queryListWithPage", method = RequestMethod.POST)
    public JsonResult queryListWithPage(RoomQueryDto roomQueryDto) {

        PageInfo pageInfo = roomService.queryListWithPage(roomQueryDto);

        return new JsonResult(true, "操作成功", pageInfo);
    }

}
