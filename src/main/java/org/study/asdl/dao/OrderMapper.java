package org.study.asdl.dao;

import org.study.asdl.model.domain.Order;
import org.study.asdl.model.dto.UserQueryDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {

    List<Order> queryListWithPage(UserQueryDto userQueryDto);
}