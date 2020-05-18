/**  
 * @Title: UserController.java
 * @Package org.study.heat.controller
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月15日
 */
package org.study.asdl.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.study.asdl.annotation.Authorization;
import org.study.asdl.annotation.CurrentUser;
import org.study.asdl.common.JsonResult;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.CheckLoginNameDto;
import org.study.asdl.model.dto.ModifyPwdDto;
import org.study.asdl.model.dto.UserQueryDto;
import org.study.asdl.service.ApartmentService;
import org.study.asdl.service.UserService;

import javax.annotation.Resource;

/**
 * ClassName: UserController 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月15日
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private ApartmentService apartmentService;
	
	/**
	 * 查看个人信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Authorization
	@RequestMapping(method = RequestMethod.GET)
	public JsonResult user(@CurrentUser User login) {
		
		return new JsonResult(true, "个人信息查询成功", login);
	}

	/**
	 * 保存用户
	 */
	@Authorization
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonResult saveUser(@CurrentUser User login, User user) {
		
		Integer result = userService.saveUser(user, login);
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
	public JsonResult deleteUserById(@PathVariable Long id) {
		
		Integer result = userService.deleteUserById(id);
		if (result < 1) {
			return new JsonResult(false, "操作失败", result);
		}
		
		return new JsonResult(true, "操作成功", result);
	}
	
	@Authorization
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
	public JsonResult modifyPwd(@CurrentUser User login, ModifyPwdDto modifyPwdDto) {
		
		Integer result = userService.modifyPwd(modifyPwdDto, login);
		if (result < 1) {
			return new JsonResult(false, "操作失败", result);
		}
		
		return new JsonResult(true, "操作成功", result);
	}
	
	/**
	 * 查询用户列表
	 */
	@Authorization
	@RequestMapping(value = "/queryListWithPage", method = RequestMethod.POST)
	public JsonResult queryUserListWithPage(UserQueryDto userQueryDto) {
		
		PageInfo pageInfo = userService.queryUserListWithPage(userQueryDto);
		
		return new JsonResult(true, "操作成功", pageInfo);
	}

	/**
	 * 校验登录名是否唯一
	 *
	 * @param checkLoginNameDto	the check login name dto
	 *
	 * @return	the json result.
	 */
	@Authorization
	@RequestMapping(value = "/checkLoginName", method = RequestMethod.POST)
	public JsonResult checkLoginName(CheckLoginNameDto checkLoginNameDto) {

		boolean result = userService.checkLoginName(checkLoginNameDto);

		return new JsonResult(true, "操作成功", result);
	}
}
