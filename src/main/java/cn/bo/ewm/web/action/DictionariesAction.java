package cn.bo.ewm.web.action;

import cn.bo.ewm.entity.Dictionaries;
import cn.bo.ewm.entity.MaintainGroup;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.*;
import cn.bo.ewm.web.action.base.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class DictionariesAction extends BaseAction<Dictionaries> {
    final static Logger logger = LoggerFactory.getLogger(DictionariesAction.class);

    public void list() throws Exception {
        DetachedCriteria dc = pageBean.getDetachedCriteria();
        dc.add(Restrictions.ne("type","sys_mg_join"));//排除sys_mg_join，维护组加入申请
        dc.add(Restrictions.sqlRestriction("type not like 'sys\\_weihuItem\\_%'"));//排除维护详情项数据
        dictionariesService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria"});
    }

    /**
     * type & value 联合搜索
     */
    public void search() throws Exception {
        DetachedCriteria dc = pageBean.getDetachedCriteria();
        if(StringUtils.isNoneBlank(model.getType())) {
            // TODO 需处理SQL注入
            dc.add(Restrictions.like("type","%"+model.getType()+"%"));
        }
        if(StringUtils.isNoneBlank(model.getValue())) {
            dc.add(Restrictions.like("value","%"+model.getValue()+"%"));
        }
        dc.add(Restrictions.ne("type","sys_mg_join"));//排除sys_mg_join，维护组加入申请
        dc.add(Restrictions.sqlRestriction("type not like 'sys\\_weihuItem\\_%'"));//排除维护详情项数据
//        dc.add(Restrictions.sqlRestriction("type not like 'sys_weihuItem_%')"));
        dictionariesService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria"});
    }

    /**
     * 查询指定Type下的数据
     * @retuen 数据类型{oid:xx,type:xx,value:xx}
     */
    public void getByType() throws Exception {
        DetachedCriteria dc = pageBean.getDetachedCriteria();
        if(StringUtils.isNoneBlank(model.getType())) {
            dc.add(Restrictions.eq("type",model.getType()));
        }
        dictionariesService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria"});
    }


    public void add() throws Exception {
        dictionariesService.save(model);
        printFlag(1);
    }

    public void update() throws Exception {

        // 先get，然后将前端传来的所有属性重设，即使前端传null，也能生效。而那些没有在前端展示更新的属性，就不会改变
        Dictionaries dictionaries = dictionariesService.findById(model.getOid());
        // 判断是新增类型还是旧类型
        if (StringUtils.isNotBlank(group)) {
            dictionaries.setType(group);
        } else {
            dictionaries.setType(model.getType());
        }
        dictionaries.setValue(model.getValue());
        dictionariesService.update(dictionaries);

        printFlag(1);
    }


    public void delete() throws Exception {
        dictionariesService.deleteBatch(ids);
        printFlag(1);
    }

    private String group;

    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 获取type分组数据
     *
     * @return 数据格式：['部门','职称']
     * @throws Exception
     */
    public void getTypeGroup() throws Exception {
        List<String> typeGroup = dictionariesService.getGroup("type");
        this.java2Json(typeGroup, null);
    }

    // 获取申请加入数据
    public void joinlist() throws Exception {
        DetachedCriteria dc = pageBean.getDetachedCriteria();
        dc.add(Restrictions.eq("type","sys_mg_join"));
        maintainGroupService.pageQuery(pageBean);
        List<Dictionaries> DictionariesList = pageBean.getData();
        maintainGroupService.clearSession();
        for (Dictionaries d :DictionariesList) {
            String[] split = d.getValue().split(",");
            Staff staff = staffService.findById(Integer.valueOf(split[0]));
            MaintainGroup maintainGroup = maintainGroupService.findById(Integer.valueOf(split[1]));
            String v = staff.getOid()+","+staff.getName()+","+maintainGroup.getOid()+","+maintainGroup.getName()+","+split[2];
            d.setValue(v);
        }

        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "records", "staffs"});
    }
}
