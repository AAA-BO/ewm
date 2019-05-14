package cn.bo.ewm.web.interceptor;

import cn.bo.ewm.entity.Staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        Object loginUser = ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if(loginUser != null) {
            return invocation.invoke();
        }
//        return "login";
        return "login_houtai";


        /*Object isLogin = ServletActionContext.getRequest().getSession().getAttribute("isLogin");
        if(isLogin != null && "true".equals(isLogin)) {
            return invocation.invoke();
        }
        return "login-admin";*/
    }
}
