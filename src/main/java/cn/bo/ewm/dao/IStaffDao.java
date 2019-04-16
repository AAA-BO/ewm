package cn.bo.ewm.dao;

import cn.bo.ewm.dao.base.IBaseDao;
import cn.bo.ewm.entity.Staff;

public interface IStaffDao extends IBaseDao<Staff> {
    Staff findByUsername(String username);
}
