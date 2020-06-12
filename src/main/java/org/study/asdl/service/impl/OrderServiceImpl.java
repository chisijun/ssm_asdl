package org.study.asdl.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.dao.OrderMapper;
import org.study.asdl.model.domain.Order;
import org.study.asdl.model.dto.UserQueryDto;
import org.study.asdl.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl extends BaseService<Order> implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public PageInfo queryListWithPage(UserQueryDto userQueryDto) {

        List<Order> orderList = orderMapper.queryListWithPage(userQueryDto);

        return new PageInfo(orderList);
    }
}
