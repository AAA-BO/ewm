package cn.bo.ewm.service;


import cn.bo.ewm.entity.Site;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface ISiteService {
    // 通用方法
    public Serializable save(Site model);
    public void update(Site site);
    public Site findById(Serializable id);
    public List<Site> findByIds(String ids);
    public List<Site> findAll();
    public void pageQuery(PageBean pageBean);
    public void deleteBatch(String ids);
}
