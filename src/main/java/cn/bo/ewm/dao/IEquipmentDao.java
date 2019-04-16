package cn.bo.ewm.dao;

import cn.bo.ewm.dao.base.IBaseDao;
import cn.bo.ewm.entity.Equipment;

import java.util.List;

public interface IEquipmentDao extends IBaseDao<Equipment> {

    List<Equipment> findNotInId(String oid);
}
