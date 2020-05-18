package org.study.asdl.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.study.asdl.annotation.Authorization;
import org.study.asdl.annotation.CurrentUser;
import org.study.asdl.common.JsonResult;
import org.study.asdl.model.domain.Lock;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.LockQueryDto;
import org.study.asdl.service.LockService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/lock")
public class LockController {

    @Resource
    private LockService lockService;

    @Authorization
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonResult saveLock(@CurrentUser User login, Lock lock) {

        Integer result = lockService.saveLock(lock, login);
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
    public JsonResult deleteLockById(@PathVariable Long id) {

        Integer result = lockService.deleteLockById(id);
        if (result < 1) {
            return new JsonResult(false, "操作失败", result);
        }

        return new JsonResult(true, "操作成功", result);
    }

    @Authorization
    @RequestMapping(value = "/queryListWithPage", method = RequestMethod.POST)
    public JsonResult queryListWithPage(LockQueryDto lockQueryDto) {

        PageInfo pageInfo = lockService.queryListWithPage(lockQueryDto);

        return new JsonResult(true, "操作成功", pageInfo);
    }

}
