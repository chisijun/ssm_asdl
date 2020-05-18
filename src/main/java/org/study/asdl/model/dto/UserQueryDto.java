/**  
 * @Title: UserQueryDto.java
 * @Package org.study.heat.dto
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月10日
 */
package org.study.asdl.model.dto;

import lombok.Data;
import org.study.asdl.base.BaseQuery;

/**
 * ClassName: UserQueryDto 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月10日
 */
@Data
public class UserQueryDto extends BaseQuery {

	/**
	 * 用户姓名
	 */
	private String userName;
	
	/**
	 * 用户类型
	 */
	private String type;


	/**
	 * 角色Id
	 */
	private Long roleId;
}
