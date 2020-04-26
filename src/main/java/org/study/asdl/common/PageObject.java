package org.study.asdl.common;

import java.io.Serializable;
import java.util.List;

/**借助此对象封装分页信息
 * @author puyijun
 * @date 2017-12-18
 * @time 13:24
 * 1)当前页
 * 2)记录数
 * 3)页数(总页数)
 * 4).....
 * */
public class PageObject<T> implements Serializable {
	private static final long serialVersionUID = -8753809986545361268L;
    /**当前页*/
	private int pageCurrent=1;
	/**记录数(表中有多少条记录)*/
	private int rowCount;
	/**总页数*/
	private int pageCount;
	/**每页要显示的记录数*/
	private int pageSize=10;
	/**取下页数据的起始记录*/
	private int startIndex;
	/**分页数据*/
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**根据当前页计算当前页记录的开始位置*/
	public int getStartIndex(){
		return (pageCurrent-1)*pageSize;
	}
	/**方法的返回值为总页数*/
	public int getPageCount(){
		//在此方法中通过rowCount,pageSize计算总页数
		int pages=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pages+=1;
		}
		return pages;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageObject{");
        sb.append("pageCurrent=").append(pageCurrent);
        sb.append(", rowCount=").append(rowCount);
        sb.append(", pageCount=").append(pageCount);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", startIndex=").append(startIndex);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}





