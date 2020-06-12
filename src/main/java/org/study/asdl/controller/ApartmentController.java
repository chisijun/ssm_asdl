package org.study.asdl.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.study.asdl.annotation.Authorization;
import org.study.asdl.annotation.CurrentUser;
import org.study.asdl.common.JsonResult;
import org.study.asdl.model.domain.Apartment;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.ApartmentQueryDto;
import org.study.asdl.service.ApartmentService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {

    @Resource
    private ApartmentService apartmentService;

    /**
     * 保存公寓
     *
     * @param login
     * @param
     * @return
     */
    @Authorization
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonResult saveApartment(@CurrentUser User login, Apartment apartment) {

//        Apartment apartment = new Apartment();

        Integer result = apartmentService.saveApartment(apartment, login);
        if (result < 1) {
            return new JsonResult(false, "操作失败", result);
        }

        return new JsonResult(true, "操作成功", result);
    }

    /**
     * 删除用户
     */
    @Authorization
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
    public JsonResult deleteApartmentById(@PathVariable Long id) {

        Integer result = apartmentService.deleteApartmentById(id);
        if (result < 1) {
            return new JsonResult(false, "操作失败", result);
        }

        return new JsonResult(true, "操作成功", result);
    }

    @Authorization
    @RequestMapping(value = "/queryListWithPage", method = RequestMethod.POST)
    public JsonResult queryListWithPage(ApartmentQueryDto apartmentQueryDto) {

        PageInfo pageInfo = apartmentService.queryListWithPage(apartmentQueryDto);

        return new JsonResult(true, "操作成功", pageInfo);
    }

    @Authorization
    @RequestMapping(value = "/queryById/{id}", method = RequestMethod.POST)
    public JsonResult queryById(@PathVariable Long id) {

        Apartment apartment = apartmentService.selectByKey(id);

        return new JsonResult(true, "操作成功", apartment);
    }

}
