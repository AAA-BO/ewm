package cn.bo.ewm.web.action;

import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.entity.Site;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IEquipmentService;
import cn.bo.ewm.service.IStaffService;
import cn.bo.ewm.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Controller
@Scope("prototype")
public class SiteAction extends BaseAction<Site> {

    public void list() throws Exception {
        siteService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","equipments","staffs" });
    }

    public void add() throws Exception {
        siteService.save(model);
        printFlag(1);
    }

    public void update() throws Exception {
        Site site = siteService.findById(model.getOid());
        site.setName(model.getName());
        site.setInfo(model.getInfo());
        siteService.update(site);
        printFlag(1);
    }

    public void delete() throws Exception {
        siteService.deleteBatch(ids);
        printFlag(1);
    }

    public void staff() throws Exception {
        Site site = siteService.findById(model.getOid());
        Set<Staff> staffs = site.getStaffs();
        pageBean.setData(new ArrayList(staffs));
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","equipments","records", "site","maintainGroups" });
    }

    public void equipment() throws Exception {
        Site site = siteService.findById(model.getOid());
        Set<Equipment> equipments = site.getEquipments();
        pageBean.setData(new ArrayList(equipments));
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","staffs","records", "site","maintainGroups"});
    }


    public String phone_home() throws Exception {
        ActionContext.getContext().getValueStack().push(siteService.findById(model.getOid()));
        return "phone_home_success";
    }

    public String phone_slist() throws Exception {
        Site site = siteService.findById(model.getOid());
        List<Staff> staffs = new ArrayList<>(site.getStaffs());

        // 使用oid排序
        staffs.sort(new Comparator<Staff>() {
            public int compare(Staff o1, Staff o2) {
                if (o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if (o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        // 维护组人员
        ServletActionContext.getRequest().setAttribute("staffs", staffs);
        return "phone_slist_success";
    }

    public String phone_elist() throws Exception {
        Site site = siteService.findById(model.getOid());
        List<Equipment> equipments = new ArrayList<>(site.getEquipments());

        // 使用oid排序
        equipments.sort(new Comparator<Equipment>() {
            public int compare(Equipment o1, Equipment o2) {
                if (o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if (o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        // 维护组人员
        ServletActionContext.getRequest().setAttribute("equipments", equipments);
        return "phone_elist_success";
    }
}
