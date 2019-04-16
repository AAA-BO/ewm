package cn.bo.ewm.dao.impl;

import cn.bo.ewm.dao.IStaffDao;
import cn.bo.ewm.dao.base.impl.BaseDaoImpl;
import cn.bo.ewm.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements IStaffDao {
    @Override
    public Staff findByUsername(String username) {
        List<Staff> staffs = (List<Staff>) getHibernateTemplate().find("from Staff s where s.username=?", username);
        return staffs.size()>0?staffs.get(0):null;
    }
}
