package cn.bo.ewm.service.impl;

import cn.bo.ewm.dao.IEquipmentDao;
import cn.bo.ewm.dao.IStaffDao;
import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IEquipmentService;
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
public class EquipmentServiceImpl  implements IEquipmentService {
    @Autowired
    private IEquipmentDao equipmentDao;
    @Autowired
    private IStaffDao staffDao;
    public void save(Equipment model) {
        equipmentDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        equipmentDao.pageQuery(pageBean);
    }

    /**
     * 批量删除
     * 物理删除
     */
    public void deleteBatch(String ids) {//1,2,3,4
        if(StringUtils.isNotBlank(ids)){
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

    public void update(Equipment Equipment) {
        equipmentDao.update(Equipment);
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentDao.findAll();
    }

    @Override
    public List<Equipment> findByIds(String ids) {
        String[] idArray = ids.split(",");
        List<Equipment> equipments = new ArrayList<>();
        for (String id : idArray) {
            equipments.add(equipmentDao.findById(Integer.valueOf(id)));
        }
        return equipments;
    }

    @Override
    public List<Equipment> getNotRelevance(Integer oid) {
        Staff staff = staffDao.findById(oid);
        StringBuilder sb  = new StringBuilder();
        for(Equipment e  : staff.getEquipments()) {
            sb.append(","+e.getOid());
        }

        return equipmentDao.findNotInId(sb.toString().substring(1));
    }


}
