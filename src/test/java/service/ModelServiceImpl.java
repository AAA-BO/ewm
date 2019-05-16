package service;


import cn.bo.ewm.service.base.BaseService;
import cn.bo.ewm.utils.PageBean;
import entity.Model;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class ModelServiceImpl extends BaseService implements IModelService {
    // 通用方法
    /*public Serializable save(Site model) {
        return siteDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        siteDao.pageQuery(pageBean);
    }
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            // 注意："1".split(",") => [1]
            String[] SiteIds = ids.split(",");
            for (String id : SiteIds) {
                Site Site = siteDao.findById(Integer.valueOf(id));
                siteDao.delete(Site);
            }
        }
    }
    public Site findById(Serializable id) {
        return siteDao.findById(id);
    }
    public void update(Site site) {
        siteDao.update(site);
    }
    public List<Site> findAll() {
        return siteDao.findAll();
    }
    public List<Site> findByIds(String ids) {
        List<Site> sites = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                sites.add(siteDao.findById(Integer.valueOf(id)));
            }
        }
        return sites;
    }*/
}
