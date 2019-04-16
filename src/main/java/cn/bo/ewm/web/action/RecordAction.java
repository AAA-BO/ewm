package cn.bo.ewm.web.action;

import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IEquipmentService;
import cn.bo.ewm.service.IRecordService;
import cn.bo.ewm.service.IStaffService;
import cn.bo.ewm.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Scope("prototype")
public class RecordAction extends BaseAction<Record> {
    @Autowired
    private IRecordService recordService;
    @Autowired
    private IEquipmentService equipmentService;
    @Autowired
    private IStaffService staffService;

    public void list() throws Exception {
        recordService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","equipments","staffs","records" });
        return;
    }

    public void add() throws Exception {
        // 获取登录用户
        Staff loginUser = (Staff) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        Staff staff = staffService.findById(loginUser.getOid());// 获取数据库最新信息

        // 获取被维护设备
        Equipment equipment = equipmentService.findById(model.getEquipment().getOid());

        Record record = new Record();
        record.setStaff(staff);
        record.setEquipment(equipment);
        record.setDate(new Date());
        record.setInfo(model.getInfo());
        recordService.save(record);
        printFlag(1);
    }

    public void update() throws Exception {
        Record record = recordService.findById(model.getOid());
        recordService.update(record);
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(1);
    }


    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public void delete() throws Exception {
        recordService.deleteBatch(ids);
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(1);
    }
}
