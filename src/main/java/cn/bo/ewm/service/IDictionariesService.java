package cn.bo.ewm.service;

import cn.bo.ewm.entity.Dictionaries;
import cn.bo.ewm.entity.Dictionaries;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IDictionariesService {
    // 通用方法
    public Serializable save(Dictionaries model);
    public void update(Dictionaries dictionaries);
    public Dictionaries findById(Serializable id);
    public List<Dictionaries> findByIds(String ids);
    public List<Dictionaries> findAll();
    public void pageQuery(PageBean pageBean);
    public void deleteBatch(String ids);
    public List<String> getGroup(String field);

    List hql(String hql);
    void clearSession();
}
