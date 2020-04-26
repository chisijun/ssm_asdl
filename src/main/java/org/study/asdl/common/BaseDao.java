package org.study.asdl.common;

/**
 * @author
 * @ClassName BaseDao
 * @date 2017-12-18
 * @time 16:12
 * @Description
 **/

public interface BaseDao<T> {
    int insertObject(T t);
    int updateObject(T t);
    int deleteObject(Integer id);
    T selectObjectById(Integer id);

    /**获得表中的记录数*/
    int getRowCount(T t);
}
