package org.study.asdl.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.study.asdl.annotation.Authorization;
import org.study.asdl.common.JsonResult;
import org.study.asdl.model.dto.UserQueryDto;
import org.study.asdl.service.OrderService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 查询订单列表
     */
    @Authorization
    @RequestMapping(value = "/queryListWithPage", method = RequestMethod.POST)
    public JsonResult queryListWithPage(UserQueryDto userQueryDto) {

        PageInfo pageInfo = orderService.queryListWithPage(userQueryDto);

        return new JsonResult(true, "操作成功", pageInfo);
    }

}
