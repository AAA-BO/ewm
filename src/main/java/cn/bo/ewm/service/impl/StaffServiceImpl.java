package cn.bo.ewm.service.impl;

import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IStaffService;
import cn.bo.ewm.service.base.BaseService;
import cn.bo.ewm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StaffServiceImpl extends BaseService implements IStaffService {
    // 通用方法
    public Serializable save(Staff model) {
        return staffDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);
    }
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            String[] StaffIds = ids.split(",");
            for (String id : StaffIds) {
                Staff Staff = staffDao.findById(Integer.valueOf(id));
                staffDao.delete(Staff);
            }
        }
    }
    public Staff findById(Serializable id) {
        return staffDao.findById(id);
    }
    public void update(Staff Staff) {
        staffDao.update(Staff);
    }
    public List<Staff> findAll() {
        return staffDao.findAll();
    }
    public List<Staff> findByIds(String ids) {
        String[] idArray = ids.split(",");
        List<Staff> staffs = new ArrayList<>();
        for (String id : idArray) {
            staffs.add(staffDao.findById(Integer.valueOf(id)));
        }
        return staffs;
    }

    // 专用方法
    public Staff findByUsername(String username) {
        return staffDao.findByUsername(username);
    }

    @Override
    public Boolean usernameExist(String username) {
        return staffDao.exist("username",username);
    }
}
