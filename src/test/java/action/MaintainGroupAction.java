package action;

import cn.bo.ewm.entity.MaintainGroup;
import cn.bo.ewm.service.*;
import cn.bo.ewm.web.action.base.BaseAction;
import entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.IMaintainGroupService;

@Controller
@Scope("prototype")
public class MaintainGroupAction extends BaseAction<MaintainGroup> {

    public String execute() throws Exception {
        return "";
    }
}
