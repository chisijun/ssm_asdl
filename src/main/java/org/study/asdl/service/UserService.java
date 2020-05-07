package org.study.asdl.service;

import com.github.pagehelper.PageInfo;
import org.study.asdl.base.IService;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.CheckLoginNameDto;
import org.study.asdl.model.dto.ModifyPwdDto;
import org.study.asdl.model.dto.UserQueryDto;

/**
 * ClassName: UserService 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月16日
 */
public interface UserService extends IService<User> {

	/**
	 * @Description: TODO
	 * @param @param currentUserId
	 * @param @return   
	 * @return User  
	 * @throws
	 * @author chisj chisj@foxmail.com
	 * @date 2019年5月23日
	 */
	User selectUserById(Long userId);

	/**
     * 用户登录
     * @param password
     * @return
     * @throws Exception
     */
    public User login(String name, String password) throws Exception;

	/**
	 * @Description: TODO
	 * @param @param user
	 * @param @return   
	 * @return Integer  
	 * @throws
	 * @author chisj chisj@foxmail.com
	 * @date 2019年6月10日
	 */
	Integer saveUser(User user, User login);
	
    /**
     * @Description: 用户列表分页查询
     * @param @param userQueryDto
     * @param @return   
     * @return PageInfo  
     * @throws
     * @author chisj chisj@foxmail.com
     * @date 2019年6月2日
     */
    PageInfo queryUserListWithPage(UserQueryDto userQueryDto);

	/**
	 * @Description: TODO
	 * @param @param id
	 * @param @return   
	 * @return Integer  
	 * @throws
	 * @author chisj chisj@foxmail.com
	 * @date 2019年6月10日
	 */
	Integer deleteUserById(Long id);

	/**
	 * @Description: TODO
	 * @param @param modifyPwdDto
	 * @param @return   
	 * @return Integer  
	 * @throws
	 * @author chisj chisj@foxmail.com
	 * @date 2019年6月10日
	 */
	Integer modifyPwd(ModifyPwdDto modifyPwdDto, User login);

	/**
	 * 校验登录名是否位置
	 *
	 * @param checkLoginNameDto	the check login name dto
	 *
	 * @return	the boolean
	 * true登录名唯一 false-登录名不唯一
	 */
	boolean checkLoginName(CheckLoginNameDto checkLoginNameDto);

}
