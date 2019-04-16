package cn.bo.ewm.service;


import cn.bo.ewm.entity.Record;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;

public interface IRecordService {

    public void save(Record model);

    public void pageQuery(PageBean pageBean);

    public void deleteBatch(String ids);

    public Record findById(Serializable id);

    public void update(Record Record);

}
