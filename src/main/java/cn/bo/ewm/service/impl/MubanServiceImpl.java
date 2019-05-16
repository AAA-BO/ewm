package cn.bo.ewm.service.impl;


import cn.bo.ewm.entity.Muban;
import cn.bo.ewm.service.IMubanService;
import cn.bo.ewm.service.base.BaseService;
import cn.bo.ewm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MubanServiceImpl extends BaseService implements IMubanService {
    // 通用方法
    public Serializable save(Muban model) {
        return mubanDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        mubanDao.pageQuery(pageBean);
    }
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            // 注意："1".split(",") => [1]
            String[] SiteIds = ids.split(",");
            for (String id : SiteIds) {
                Muban Muban = mubanDao.findById(Integer.valueOf(id));
                mubanDao.delete(Muban);
            }
        }
    }

    @Override
    public List hql(String hql) {
        return mubanDao.hql(hql);
    }
    @Override
    public List sql(String sql) {
        return mubanDao.sql(sql);
    }

    public Muban findById(Serializable id) {
        return mubanDao.findById(id);
    }
    public void update(Muban muban) {
        mubanDao.update(muban);
    }
    public List<Muban> findAll() {
        return mubanDao.findAll();
    }
    public List<Muban> findByIds(String ids) {
        List<Muban> mubans = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                mubans.add(mubanDao.findById(Integer.valueOf(id)));
            }
        }
        return mubans;
    }

    @Override
    public void deleteBatchByName(String names) {
        if(StringUtils.isNotBlank(names)) {
            String[] nameArray = names.split(",");
            for (String name :nameArray) {
                DetachedCriteria dc = DetachedCriteria.forClass(Muban.class);
                dc.add(Restrictions.eq("name",name));
                List<Muban> mubanList = mubanDao.findByCriteria(dc);
                if(mubanList.size()>0) {
                    for (Muban muban:mubanList) {
                        mubanDao.delete(muban);
                    }
                }
            }
        }
    }
}
