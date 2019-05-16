package cn.bo.ewm.service;

import cn.bo.ewm.entity.Muban;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IMubanService {
    // 通用方法
    public Serializable save(Muban model);
    public void update(Muban site);
    public Muban findById(Serializable id);
    public List<Muban> findByIds(String ids);
    public List<Muban> findAll();
    public void pageQuery(PageBean pageBean);
    public void deleteBatch(String ids);
    List hql(String hql);

    List sql(String sql);

    // 特有，通过模板名批量删除
    void deleteBatchByName(String names);

}
