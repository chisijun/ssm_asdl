/**  
 * @Title: StatusEnum.java
 * @Package org.study.heat.enums
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月28日
 */
package org.study.asdl.model.enums;

/**
 * ClassName: StatusEnum 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月28日
 */
public enum StatusEnum {

	/**
	 * 启用
	 */
	ENABLE("ENABLE", "启用"),
	/**
	 * 禁用
	 */
	DISABLE("DISABLE", "禁用");

	/**
	 * The Type.
	 */
	String type;
	/**
	 * The Name.
	 */
	String name;

	StatusEnum(String type, String name) {
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
		for (StatusEnum ele : StatusEnum.values()) {
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
	public static StatusEnum getEnum(String type) {
		for (StatusEnum ele : StatusEnum.values()) {
			if (type.equals(ele.getType())) {
				return ele;
			}
		}
		return StatusEnum.ENABLE;
	}
	
}
