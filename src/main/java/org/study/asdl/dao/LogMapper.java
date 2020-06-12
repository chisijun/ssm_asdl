package org.study.asdl.dao;

import org.study.asdl.model.domain.Log;
import org.study.asdl.model.dto.LockQueryDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LogMapper extends Mapper<Log> {

    List<Log> queryListWithPage(LockQueryDto lockQueryDto);
}