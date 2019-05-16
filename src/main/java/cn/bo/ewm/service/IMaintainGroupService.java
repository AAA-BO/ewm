package cn.bo.ewm.service;

import cn.bo.ewm.entity.MaintainGroup;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IMaintainGroupService {
    // 通用方法
    public Serializable save(MaintainGroup model);
    public void update(MaintainGroup saintainGroup);
    public MaintainGroup findById(Serializable id);
    public List<MaintainGroup> findByIds(String ids);
    public List<MaintainGroup> findAll();
    public void pageQuery(PageBean pageBean);
    public void deleteBatch(String ids);

    void clearSession();
}
