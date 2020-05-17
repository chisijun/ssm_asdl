package org.study.asdl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.dao.ApartmentMapper;
import org.study.asdl.model.domain.Apartment;
import org.study.asdl.model.domain.Room;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.ApartmentQueryDto;
import org.study.asdl.service.ApartmentService;
import org.study.asdl.service.RoomService;

import javax.annotation.Resource;
import java.util.List;

@Service("apartmentService")
public class ApartmentServiceImpl extends BaseService<Apartment> implements ApartmentService {

    @Resource
    private ApartmentMapper apartmentMapper;
    @Resource
    private RoomService roomService;

    @Override
    public Integer saveApartment(Apartment apartment, User login) {

        apartment.setUpdateInfo(login);

        if (apartment.isNew()) {

            return apartmentMapper.insertSelective(apartment);
        } else {

            return apartmentMapper.updateByPrimaryKeySelective(apartment);
        }
    }

    @Override
    public Integer deleteApartmentById(Long id) {

        // 判断是否已经添加了房间
        Room room = new Room();
        room.setApartmentId(id);
        int count = roomService.selectCount(room);
        if (count > 0) {
            throw new RuntimeException("公寓已经添加了房间");
        }

        return apartmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo queryListWithPage(ApartmentQueryDto apartmentQueryDto) {

        PageHelper.startPage(apartmentQueryDto.getPageNum(), apartmentQueryDto.getPageSize());

        List<Apartment> apartmentList = apartmentMapper.queryListWithPage(apartmentQueryDto);

        return new PageInfo<>(apartmentList);
    }
}
