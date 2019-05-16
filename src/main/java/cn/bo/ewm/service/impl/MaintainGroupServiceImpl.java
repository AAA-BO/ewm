package cn.bo.ewm.service.impl;


import cn.bo.ewm.entity.MaintainGroup;
import cn.bo.ewm.service.IMaintainGroupService;
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
public class MaintainGroupServiceImpl extends BaseService implements IMaintainGroupService {
    // 通用方法
    public Serializable save(MaintainGroup model) {
        return maintainGroupDao.save(model);
    }
    public void pageQuery(PageBean pageBean) {
        maintainGroupDao.pageQuery(pageBean);
    }
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            // 注意："1".split(",") => [1]
            String[] MaintainGroupIds = ids.split(",");
            for (String id : MaintainGroupIds) {
                MaintainGroup MaintainGroup = maintainGroupDao.findById(Integer.valueOf(id));
                maintainGroupDao.delete(MaintainGroup);
            }
        }
    }

    @Override
    public void clearSession() {
        maintainGroupDao.clearSession();
    }

    public MaintainGroup findById(Serializable id) {
        return maintainGroupDao.findById(id);
    }
    public void update(MaintainGroup maintainGroup) {
        maintainGroupDao.update(maintainGroup);
    }
    public List<MaintainGroup> findAll() {
        return maintainGroupDao.findAll();
    }
    public List<MaintainGroup> findByIds(String ids) {
        List<MaintainGroup> maintainGroups = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                maintainGroups.add(maintainGroupDao.findById(Integer.valueOf(id)));
            }
        }
        return maintainGroups;
    }
}
