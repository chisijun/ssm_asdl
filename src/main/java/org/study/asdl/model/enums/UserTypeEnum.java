/**  
 * @Title: UserTypeEnum.java
 * @Package org.study.heat.enums
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月10日
 */
package org.study.asdl.model.enums;

/**
 * ClassName: UserTypeEnum 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月10日
 */
public enum UserTypeEnum {

	/**
	 * 管理员
	 */
	ADMIN("admin", "管理员"),
	/**
	 * 用户
	 */
	USER("user", "用户");

	/**
	 * The Type.
	 */
	String type;
	/**
	 * The Name.
	 */
	String name;

	UserTypeEnum(String type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * Gets type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Gets name.
	 *
	 * @param type the type
	 *
	 * @return the name
	 */
	public static String getName(String type) {
		for (UserTypeEnum ele : UserTypeEnum.values()) {
			if (type.equals(ele.getType())) {
				return ele.getName();
			}
		}
		return null;
	}

	/**
	 * Gets enum.
	 *
	 * @param type the type
	 *
	 * @return the enum
	 */
	public static UserTypeEnum getEnum(String type) {
		for (UserTypeEnum ele : UserTypeEnum.values()) {
			if (type.equals(ele.getType())) {
				return ele;
			}
		}
		return UserTypeEnum.USER;
	}
	
}
