package org.study.asdl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.dao.LogMapper;
import org.study.asdl.model.domain.Log;
import org.study.asdl.model.dto.LockQueryDto;
import org.study.asdl.service.LogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2020/6/12 22:10
 * @Description: TODO
 */
@Service
public class LogServiceImpl extends BaseService<Log> implements LogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public PageInfo queryListWithPage(LockQueryDto lockQueryDto) {

        PageHelper.startPage(lockQueryDto.getPageNum(), lockQueryDto.getPageSize());

        List<Log> logList = logMapper.queryListWithPage(lockQueryDto);

        return new PageInfo<>(logList);
    }
}
