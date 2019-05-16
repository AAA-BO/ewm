package cn.bo.ewm.service.impl;


import cn.bo.ewm.entity.Dictionaries;
import cn.bo.ewm.entity.Dictionaries;
import cn.bo.ewm.service.IDictionariesService;
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
public class DictionariesServiceImpl extends BaseService implements IDictionariesService {
    // 通用方法
    public Serializable save(Dictionaries model) {
        return dictionariesDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        dictionariesDao.pageQuery(pageBean);
    }
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            // 注意："1".split(",") => [1]
            String[] DictionariesIds = ids.split(",");
            for (String id : DictionariesIds) {
                Dictionaries Dictionaries = dictionariesDao.findById(Integer.valueOf(id));
                dictionariesDao.delete(Dictionaries);
            }
        }
    }

    @Override
    public List<String> getGroup(String field) {
        return dictionariesDao.selectGroupDataByField(field);
    }

    @Override
    public List hql(String hql) {
        return dictionariesDao.hql(hql);
    }

    @Override
    public void clearSession() {
        dictionariesDao.clearSession();
    }

    public Dictionaries findById(Serializable id) {
        return dictionariesDao.findById(id);
    }
    public void update(Dictionaries dictionaries) {
        dictionariesDao.update(dictionaries);
    }
    public List<Dictionaries> findAll() {
        return dictionariesDao.findAll();
    }
    public List<Dictionaries> findByIds(String ids) {
        List<Dictionaries> dictionariess = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                dictionariess.add(dictionariesDao.findById(Integer.valueOf(id)));
            }
        }
        return dictionariess;
    }


}
