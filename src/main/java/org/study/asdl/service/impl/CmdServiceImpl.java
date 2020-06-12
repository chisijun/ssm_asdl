package org.study.asdl.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.dao.CmdMapper;
import org.study.asdl.model.domain.Cmd;
import org.study.asdl.model.dto.LockQueryDto;
import org.study.asdl.service.CmdService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2020/6/12 23:24
 * @Description: TODO
 */
@Service
public class CmdServiceImpl extends BaseService<Cmd> implements CmdService {

    @Resource
    private CmdMapper cmdMapper;

    @Override
    public PageInfo queryListWithPage(LockQueryDto lockQueryDto) {

        List<Cmd> cmdList = cmdMapper.queryListWithPage(lockQueryDto);

        return new PageInfo<>(cmdList);
    }
}
