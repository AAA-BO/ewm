package cn.bo.ewm.dao.base;

import java.io.Serializable;
import java.util.List;

import cn.bo.ewm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;


/**
 * 持久层通用接口
 */
public interface IBaseDao<T> {
	public Serializable save(T entity);

	public void delete(T entity);

	public void update(T entity);

	public void saveOrUpdate(T entity);

	public T findById(Serializable id);

	public List<T> findAll();

	public List<T> findByCriteria(DetachedCriteria detachedCriteria);

	public void executeUpdate(String queryName, Object... objects);

	public void pageQuery(PageBean pageBean);

	/**
	 * 检测某个字段是否存在某个值
	 *
	 * @param field 字段
	 * @param value 要检测的值
	 * @return true：存在 false：不存在
	 */
	Boolean exist(String field, String value);

	/**
	 * 获取指定字段的GroupBy数据
	 *
	 * @param field 指定的字段
	 * @return ['部门','职称']
	 */
	List<String> selectGroupDataByField(String field);

	List hql(String hql);

	List sql(String sql);

	void clearSession();
}
