package cn.bo.ewm.service;


import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IStaffService {
    // 通用方法
    public Serializable save(Staff model);
    public void update(Staff staff);
    public Staff findById(Serializable id);
    public List<Staff> findByIds(String ids);
    public List<Staff> findAll();
    public void pageQuery(PageBean pageBean);
    public void deleteBatch(String ids);

    // 专用方法

    /**
     * 通过账户密码查询
     * @param username
     * @return
     */
    public Staff findByUsername(String  username);

    /**
     * 检测账户username是否已存在
     * @return true-存在，false-不存在
     */
    Boolean usernameExist(String username);

}
