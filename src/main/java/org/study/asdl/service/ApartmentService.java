package org.study.asdl.service;

import com.github.pagehelper.PageInfo;
import org.study.asdl.base.IService;
import org.study.asdl.model.domain.Apartment;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.ApartmentQueryDto;

public interface ApartmentService extends IService<Apartment> {

    /**
     * save apartment
     *
     * @param apartment
     * @param login
     *
     * @return
     */
    Integer saveApartment(Apartment apartment, User login);

    /**
     * delete apartment by id
     *
     * @param id
     * @return
     */
    Integer deleteApartmentById(Long id);

    /**
     * query apartment list with page
     *
     * @param apartmentQueryDto
     *
     * @return
     */
    PageInfo queryListWithPage(ApartmentQueryDto apartmentQueryDto);
}
