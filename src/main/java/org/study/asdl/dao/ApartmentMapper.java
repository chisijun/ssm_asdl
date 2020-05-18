package org.study.asdl.dao;

import org.study.asdl.model.domain.Apartment;
import org.study.asdl.model.dto.ApartmentQueryDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ApartmentMapper extends Mapper<Apartment> {

    List<Apartment> queryListWithPage(ApartmentQueryDto apartmentQueryDto);
}