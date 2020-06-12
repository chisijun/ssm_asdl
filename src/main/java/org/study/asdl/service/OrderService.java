package org.study.asdl.service;

import com.github.pagehelper.PageInfo;
import org.study.asdl.base.IService;
import org.study.asdl.model.domain.Order;
import org.study.asdl.model.dto.UserQueryDto;

public interface OrderService extends IService<Order> {

    PageInfo queryListWithPage(UserQueryDto userQueryDto);
}
