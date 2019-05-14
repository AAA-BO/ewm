package cn.bo.ewm.service.impl;

import cn.bo.ewm.dao.IEquipmentDao;
import cn.bo.ewm.dao.IStaffDao;
import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IEquipmentService;
import cn.bo.ewm.service.base.BaseService;
import cn.bo.ewm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl extends BaseService implements IEquipmentService {
    // 通用方法
    public Serializable save(Equipment model) {
        return equipmentDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        equipmentDao.pageQuery(pageBean);
    }
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            // 注意："1".split(",") => [1]
            String[] EquipmentIds = ids.split(",");
            for (String id : EquipmentIds) {
                Equipment Equipment = equipmentDao.findById(Integer.valueOf(id));
                equipmentDao.delete(Equipment);
            }
        }
    }
    public Equipment findById(Serializable id) {
        return equipmentDao.findById(id);
    }
    public void update(Equipment equipment) {
        equipmentDao.update(equipment);
    }
    public List<Equipment> findAll() {
        return equipmentDao.findAll();
    }
    public List<Equipment> findByIds(String ids) {
        List<Equipment> equipments = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                equipments.add(equipmentDao.findById(Integer.valueOf(id)));
            }
        }
        return equipments;
    }

    // 专用方法
    public List<Equipment> getNotRelevance(Integer oid) {
        Staff staff = staffDao.findById(oid);
        StringBuilder sb  = new StringBuilder();
        for(Equipment e  : staff.getEquipments()) {
            sb.append(","+e.getOid());
        }
        String s = sb.toString();
        if("".equals(s)) {
            return equipmentDao.findAll();
        }
        return equipmentDao.findNotInId(s.substring(1));
    }


}
