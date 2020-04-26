package org.study.asdl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.asdl.annotation.Authorization;
import org.study.asdl.annotation.CurrentUser;
import org.study.asdl.common.JsonResult;
import org.study.asdl.netty.RelayMessageHandler;
import org.study.asdl.netty.entity.RelayCmdStachEntity;

import javax.annotation.Resource;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2020-04-26 15:26
 * @Description:
 */
@RestController
@RequestMapping("/relay")
public class RelayController {

    @Resource
    private RelayMessageHandler relayMessageHandler;

    /**
     * 审批
     */
    @PostMapping("/startStach")
    public JsonResult startStach(@RequestBody RelayCmdStachEntity relayCmdStachEntity) {

        try {
            relayCmdStachEntity.setSta(1);
            relayMessageHandler.setStach(relayCmdStachEntity);

            // 关闭延迟时长
            Thread.sleep(1000);

            relayCmdStachEntity.setSta(0);
            relayMessageHandler.setStach(relayCmdStachEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JsonResult(true, "操作成功", null);
    }
}
