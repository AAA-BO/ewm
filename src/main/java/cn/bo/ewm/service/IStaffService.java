package cn.bo.ewm.service;


import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IStaffService {

    public void save(Staff model);

    public void pageQuery(PageBean pageBean);

    public void deleteBatch(String ids);

    public Staff findById(Serializable id);

    public Staff findByUsername(String  username);

    public void update(Staff staff);



}
