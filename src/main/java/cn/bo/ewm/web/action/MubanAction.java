package cn.bo.ewm.web.action;

import cn.bo.ewm.entity.Muban;
import cn.bo.ewm.service.*;
import cn.bo.ewm.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class MubanAction extends BaseAction<Muban> {

    public void list() throws Exception {
        int page = pageBean.getPage();
        int limit = pageBean.getLimit();
        List names = mubanService.sql("select t.name from e_muban t group by t.name limit " + (page - 1) + "," + limit);
        List<Muban> mubans = new ArrayList<>();
        for (Object o : names) {
            Muban muban = new Muban();
            muban.setName(o.toString());
            mubans.add(muban);
        }
        pageBean.setCount(mubans.size());
        pageBean.setData(mubans);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria"});
    }

    public void listByNameNotWith() throws Exception {
        // TODO 中文编码异常
        List names = mubanService.sql("select t.name from e_muban t group by t.name having t.name!='"+model.getName()+"'");
        List<Muban> mubans = new ArrayList<>();
        for (Object o : names) {
            Muban muban = new Muban();
            muban.setName(o.toString());
            mubans.add(muban);
        }
        pageBean.setCount(mubans.size());
        pageBean.setData(mubans);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria"});
    }


    /**
     * [{name:asd,filedName:aaa,filedType:文本框,filedItem:''},{name:asd,filedName:sss,filedType:日期时间,filedItem:''},{name:asd,filedName:ddd,filedType:复选框,filedItem:d1|d2|d3NaN}]
     * name:asd,filedName:aaa,filedType:文本框,filedItem:''
     */
    private String mubanData;

    public void setMubanData(String mubanData) {
        this.mubanData = mubanData;
    }

    public void add() throws Exception {

        if (mubanData.length() > 2) {
            mubanData = mubanData.substring(2, mubanData.length() - 2);
            for (String one : mubanData.split("\\},\\{")) {
                Muban muban = new Muban();
                for (String item : one.split(",")) {
                    String[] prop = item.split(":");
                    if ("name".equals(prop[0])) {
                        muban.setName(prop[1]);
                    } else if ("filedName".equals(prop[0])) {
                        muban.setFiledName(prop[1]);
                    } else if ("filedType".equals(prop[0])) {
                        muban.setFiledType(prop[1]);
                    } else if ("filedItem".equals(prop[0])) {
                        muban.setFiledItem(prop[1]);
                    }
                }
                mubanService.save(muban);
            }
        }
        printFlag(1);
    }


    public void show() throws Exception {
        DetachedCriteria dc = pageBean.getDetachedCriteria();
        dc.add(Restrictions.eq("name",model.getName()));
        mubanService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria"});
    }

    private String names;
    public void setNames(String names) {
        this.names = names;
    }

    public void delete() throws Exception {
        mubanService.deleteBatchByName(names);
        printFlag(1);
    }


}
