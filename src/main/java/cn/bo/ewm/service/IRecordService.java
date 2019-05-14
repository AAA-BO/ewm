package cn.bo.ewm.service;


import cn.bo.ewm.entity.Record;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IRecordService {
    // 通用方法
    public Serializable save(Record model);
    public void update(Record record);
    public Record findById(Serializable id);
    public List<Record> findByIds(String ids);
    public List<Record> findAll();
    public void pageQuery(PageBean pageBean);
    public void deleteBatch(String ids);

    List hql(String hql);

    List sql(String s);
}
