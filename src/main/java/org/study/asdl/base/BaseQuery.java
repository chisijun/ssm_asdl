/**  
 * @Title: BaseQuery.java
 * @Package org.study.heat.base
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月28日
 */
package org.study.asdl.base;

import lombok.Data;

/**
 * ClassName: BaseQuery 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年5月28日
 */
@Data
public class BaseQuery {
	
	private static final long serialVersionUID = 3319698607712846427L;

	/**
	 * 当前页
	 */
	private Integer pageNum = 1;

	/**
	 * 每页条数
	 */
	private Integer pageSize = 10;

	/**
	 * 排序
	 */
	private String orderBy;
}
