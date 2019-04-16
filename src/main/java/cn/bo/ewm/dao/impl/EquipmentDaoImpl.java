package cn.bo.ewm.dao.impl;

import cn.bo.ewm.dao.IEquipmentDao;
import cn.bo.ewm.dao.base.impl.BaseDaoImpl;
import cn.bo.ewm.entity.Equipment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentDaoImpl extends BaseDaoImpl<Equipment> implements IEquipmentDao {
    @Override
    public List<Equipment> findNotInId(String ids) {
        return (List<Equipment>) getHibernateTemplate().find("From Equipment e where e.oid not in ("+ids+")");
    }
}
