/**  
 * @Title: UserServiceImpl.java
 * @Package org.study.heat.service.impl
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月16日
 */
package org.study.asdl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.study.asdl.base.BaseService;
import org.study.asdl.dao.RoleUserMapper;
import org.study.asdl.dao.UserMapper;
import org.study.asdl.model.domain.RoleUser;
import org.study.asdl.model.domain.User;
import org.study.asdl.model.dto.CheckLoginNameDto;
import org.study.asdl.model.dto.ModifyPwdDto;
import org.study.asdl.model.dto.UserQueryDto;
import org.study.asdl.model.enums.UserTypeEnum;
import org.study.asdl.model.vo.UserVo;
import org.study.asdl.service.UserService;
import org.study.asdl.utils.MD5;
import org.study.asdl.utils.PublicUtil;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: UserServiceImpl 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月16日
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private RoleUserMapper roleUserMapper;

	
	/* (non-Javadoc)
	 * @see org.study.heat.service.UserService#selectUserById(java.lang.Integer)
	 */
	@Override
	public User selectUserById(Long userId) {
		// TODO Auto-generated method stub

		// return userMapper.selectByPrimaryKey(userId);

		// 查询用户角色信息
		return userMapper.selectByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see org.study.heat.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String loginName, String password) throws Exception {
		// TODO Auto-generated method stub
		if (loginName == null || password == null) {
            throw new RuntimeException("参数传递异常");
        }

        if (StringUtils.isBlank(loginName)) {
            throw new RuntimeException("请输入用户名！");
        }

        if (StringUtils.isBlank(password)) {
            throw new RuntimeException("请输入密码！");
        }

        // 密码加密 
        /** 
         * 通过手机号码校验 
         * */
        password = MD5.getMd5().getMD5ofStr(password);
        User user = userMapper.selectByLoginName(loginName);

        if (user== null) {
            throw new RuntimeException("用户名不存在.");
        }
        
        System.out.println("user = " + user);
        
        System.out.println("password = " + password);
        System.out.println("pwd = " + user.getLoginPwd());
        if (!password.equals(user.getLoginPwd())) {
        	throw new RuntimeException("密码错误.");
        }
        
        return user;
	}

	/* (non-Javadoc)
	 * @see org.study.heat.service.UserService#saveUser(org.study.heat.pojo.User)
	 */
	@Override
	public Integer saveUser(User user, User login) {
		// TODO Auto-generated method stub
		
		user.setUpdateInfo(login);
		
		if (user.isNew()) {
			String password = MD5.getMd5().getMD5ofStr("123456");
			user.setType(UserTypeEnum.USER.getType());
			user.setLoginPwd(password);

			int result = userMapper.insertSelective(user);

			// 保存角色
			RoleUser roleUser = new RoleUser();
			roleUser.setUserId(user.getId());
			roleUser.setRoleId(2l);
			roleUserMapper.insert(roleUser);

			return result;
		} else {
			
			return userMapper.updateByPrimaryKeySelective(user);
		}
	}

	/* (non-Javadoc)
	 * @see org.study.heat.service.UserService#queryUserListWithPage(org.study.heat.dto.UserQueryDto)
	 */
	@Override
	public PageInfo queryUserListWithPage(UserQueryDto userQueryDto) {
		// TODO Auto-generated method stub
		userQueryDto.setType(UserTypeEnum.USER.getType());
		
		PageHelper.startPage(userQueryDto.getPageNum(), userQueryDto.getPageSize());
		List<UserVo> userList = userMapper.queryUserListWithPage(userQueryDto);
		
		return new PageInfo<>(userList);
	}

	/* (non-Javadoc)
	 * @see org.study.heat.service.UserService#deleteUserById(java.lang.Long)
	 */
	@Override
	public Integer deleteUserById(Long id) {
		// TODO Auto-generated method stub

		// 删除用户角色
		RoleUser roleUser = new RoleUser();
		roleUser.setUserId(id);
		roleUserMapper.delete(roleUser);

		return userMapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see org.study.heat.service.UserService#modifyPwd(org.study.heat.dto.ModifyPwdDto)
	 */
	@Override
	public Integer modifyPwd(ModifyPwdDto modifyPwdDto, User login) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(modifyPwdDto.getId());
		if (PublicUtil.isEmpty(user)) {
			throw new RuntimeException("用户不存在");
		}
		
		if (!modifyPwdDto.getPassword().equals(modifyPwdDto.getConfirmPwd())) {
			throw new RuntimeException("两次密码不一致");
		}
		
		String password = MD5.getMd5().getMD5ofStr(modifyPwdDto.getPassword());
		
		user = new User();
		user.setUpdateInfo(login);
		user.setId(modifyPwdDto.getId());
		user.setLoginPwd(password);
		
		return userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 校验登录名是否位置
	 *
	 * @param checkLoginNameDto the check login name dto
	 *
	 * @return the boolean
	 * true登录名唯一 false-登录名不唯一
	 */
	@Override
	public boolean checkLoginName(CheckLoginNameDto checkLoginNameDto) {

		Long id = checkLoginNameDto.getUserId();
		String loginName = checkLoginNameDto.getLoginName();

		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("loginName", loginName);
		if (id != null) {
			criteria.andNotEqualTo("id", id);
		}

		int result = selectCountByExample(example);

		return result < 1;
	}

}
