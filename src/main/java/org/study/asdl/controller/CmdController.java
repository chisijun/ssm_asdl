package org.study.asdl.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.study.asdl.annotation.Authorization;
import org.study.asdl.common.JsonResult;
import org.study.asdl.model.dto.LockQueryDto;
import org.study.asdl.service.CmdService;

import javax.annotation.Resource;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2020/6/12 23:25
 * @Description: TODO
 */
@RestController
@RequestMapping("/cmd")
public class CmdController {

    @Resource
    private CmdService cmdService;

    @Authorization
    @RequestMapping(value = "/queryListWithPage", method = RequestMethod.POST)
    public JsonResult queryListWithPage(LockQueryDto lockQueryDto) {

        PageInfo pageInfo = cmdService.queryListWithPage(lockQueryDto);

        return new JsonResult(true, "操作成功", pageInfo);
    }

}
