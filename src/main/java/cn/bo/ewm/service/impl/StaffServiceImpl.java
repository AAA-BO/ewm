package cn.bo.ewm.service.impl;

import cn.bo.ewm.dao.IStaffDao;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IStaffService;
import cn.bo.ewm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class StaffServiceImpl  implements IStaffService {
    @Autowired
    private IStaffDao staffDao;
    public void save(Staff model) {
        staffDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);
    }

    /**
     * 批量删除
     * 物理删除
     */
    public void deleteBatch(String ids) {//1,2,3,4
        if(StringUtils.isNotBlank(ids)){
            String[] staffIds = ids.split(",");
            for (String id : staffIds) {
                Staff staff = staffDao.findById(Integer.valueOf(id));
                staffDao.delete(staff);
            }
        }
    }

    public Staff findById(Serializable id) {
        return staffDao.findById(id);
    }

    @Override
    public Staff findByUsername(String username) {
        return staffDao.findByUsername(username);
    }

    public void update(Staff staff) {
        staffDao.update(staff);
    }


}
