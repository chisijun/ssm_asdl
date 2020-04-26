/**  
 * @Title: ModifyPwdDto.java
 * @Package org.study.heat.dto
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月10日
 */
package org.study.asdl.model.dto;

import lombok.Data;

/**
 * ClassName: ModifyPwdDto 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月10日
 */
@Data
public class ModifyPwdDto {

	/**
	 * 用户Id
	 */
	private Long id;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 确认密码
	 */
	private String confirmPwd;
	
}
