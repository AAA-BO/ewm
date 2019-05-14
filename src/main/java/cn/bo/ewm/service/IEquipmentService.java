package cn.bo.ewm.service;

import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IEquipmentService {
    // 通用方法
    public Serializable save(Equipment model);
    public void update(Equipment equipment);
    public Equipment findById(Serializable id);
    public List<Equipment> findByIds(String ids);
    public List<Equipment> findAll();
    public void pageQuery(PageBean pageBean);
    public void deleteBatch(String ids);

    // 专用方法
    List<Equipment> getNotRelevance(Integer oid);
}
