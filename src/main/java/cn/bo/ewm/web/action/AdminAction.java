package cn.bo.ewm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport {
    private String username;
    private String password;
    private String remember;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember() {
        return remember;
    }
    public void setRemember(String remember) {
        this.remember = remember;
    }

    public String loginPage() throws Exception {
        // 判断cookie中是否有已经记住的帐户密码
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        for(Cookie cookie : cookies) {
            if("username".equals(cookie.getName())) {
                username = cookie.getValue();
            }else if("password".equals(cookie.getName())) {
                password = cookie.getValue();
            }
        }
        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            if(DigestUtils.md5Hex("admin" + "salt").equals(username) && DigestUtils.md5Hex("admin" + "salt").equals(password)) {
                ServletActionContext.getRequest().getSession().setAttribute("isLogin","true");
                return "success";
            }
        }

        return "login";
    }

    public String login() throws Exception {
        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            if("admin".equals(username) && "admin".equals(password)) {
                // 记住我功能实现
                if(StringUtils.isNotBlank(remember) && "true".equals(remember)) {
                    HttpServletResponse response = ServletActionContext.getResponse();
                    // 使用MD5加密下
                    Cookie usernameCookie = new Cookie("username", DigestUtils.md5Hex("admin" + "salt"));
                    usernameCookie.setMaxAge(60*60*24*7);// 7天后过期
                    Cookie passwordCookie = new Cookie("password", DigestUtils.md5Hex("admin" + "salt"));
                    passwordCookie.setMaxAge(60*60*24*7);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                }

                ServletActionContext.getRequest().getSession().setAttribute("isLogin","true");
                return "success";
            }
        }
        ServletActionContext.getRequest().setAttribute("msg","用户名或密码错误");
        return "login";
    }

    public String logout() throws Exception {
        // 销毁session
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.getSession().invalidate();
        // 清除cookie
        Cookie usernameCookie = new Cookie("username", "");
        usernameCookie.setMaxAge(-1);// 7天后过期
        Cookie passwordCookie = new Cookie("password", "");
        passwordCookie.setMaxAge(-1);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
        return "login";
    }
}
