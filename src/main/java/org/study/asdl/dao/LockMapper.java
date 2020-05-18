package org.study.asdl.dao;

import org.study.asdl.model.domain.Lock;
import org.study.asdl.model.dto.LockQueryDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LockMapper extends Mapper<Lock> {

    List<Lock> queryListWithPage(LockQueryDto lockQueryDto);
}