package action;

import cn.bo.ewm.service.*;
import cn.bo.ewm.web.action.base.BaseAction;
import entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ModelAction extends BaseAction<Model> {
    @Autowired
    private IEquipmentService equipmentService;
    @Autowired
    private IStaffService staffService;
    @Autowired
    private IRecordService recordService;
    @Autowired
    private ISiteService siteService;
    @Autowired
    private IDictionariesService dictionariesService;

    public String execute() throws Exception {
        return "";
    }
}
