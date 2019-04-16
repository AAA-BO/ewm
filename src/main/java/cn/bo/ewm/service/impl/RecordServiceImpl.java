package cn.bo.ewm.service.impl;

import cn.bo.ewm.dao.IRecordDao;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.service.IRecordService;
import cn.bo.ewm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
@Transactional
public class RecordServiceImpl implements IRecordService {
    @Autowired
    private IRecordDao recordDao;
    public void save(Record model) {
        recordDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        recordDao.pageQuery(pageBean);
    }

    /**
     * 批量删除
     * 物理删除
     */
    public void deleteBatch(String ids) {//1,2,3,4
        if(StringUtils.isNotBlank(ids)){
            String[] RecordIds = ids.split(",");
            for (String id : RecordIds) {
                Record Record = recordDao.findById(Integer.valueOf(id));
                recordDao.delete(Record);
            }
        }
    }

    public Record findById(Serializable id) {
        return recordDao.findById(id);
    }

    public void update(Record Record) {
        recordDao.update(Record);
    }


}
