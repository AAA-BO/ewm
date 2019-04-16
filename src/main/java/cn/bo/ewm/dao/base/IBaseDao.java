package cn.bo.ewm.dao.base;

import java.io.Serializable;
import java.util.List;

import cn.bo.ewm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;


/**
 * 持久层通用接口
 */
public interface IBaseDao<T> {
    public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public void saveOrUpdate(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
	public void executeUpdate(String queryName,Object...objects);
	public void pageQuery(PageBean pageBean);
}
