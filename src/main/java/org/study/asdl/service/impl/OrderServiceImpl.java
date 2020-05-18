package org.study.asdl.service.impl;

import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.model.domain.Order;
import org.study.asdl.service.OrderService;

@Service("orderService")
public class OrderServiceImpl extends BaseService<Order> implements OrderService {
}
