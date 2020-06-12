package org.study.asdl.dao;

import org.study.asdl.model.domain.Cmd;
import org.study.asdl.model.dto.LockQueryDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CmdMapper extends Mapper<Cmd> {

    List<Cmd> queryListWithPage(LockQueryDto lockQueryDto);
}