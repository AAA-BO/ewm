package cn.bo.ewm.service;

import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IEquipmentService {
    public void save(Equipment model);

    public void pageQuery(PageBean pageBean);

    public void deleteBatch(String ids);

    public Equipment findById(Serializable id);

    public void update(Equipment Equipment);

    public List<Equipment> findAll();

    public List<Equipment> findByIds(String ids);

    List<Equipment> getNotRelevance(Integer oid);
}
