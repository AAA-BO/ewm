package cn.bo.ewm.service.impl;

import cn.bo.ewm.dao.IRecordDao;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.service.IRecordService;
import cn.bo.ewm.service.base.BaseService;
import cn.bo.ewm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RecordServiceImpl extends BaseService implements IRecordService {
    // 通用方法
    public Serializable save(Record model) {
        return recordDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        recordDao.pageQuery(pageBean);
    }
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            // 注意："1".split(",") => [1]
            String[] RecordIds = ids.split(",");
            for (String id : RecordIds) {
                Record Record = recordDao.findById(Integer.valueOf(id));
                recordDao.delete(Record);
            }
        }
    }

    @Override
    public List hql(String hql) {
        return recordDao.hql(hql);
    }
    @Override
    public List sql(String sql) {
        return recordDao.sql(sql);
    }

    public Record findById(Serializable id) {
        return recordDao.findById(id);
    }
    public void update(Record record) {
        recordDao.update(record);
    }
    public List<Record> findAll() {
        return recordDao.findAll();
    }
    public List<Record> findByIds(String ids) {
        List<Record> records = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                records.add(recordDao.findById(Integer.valueOf(id)));
            }
        }
        return records;
    }

}
