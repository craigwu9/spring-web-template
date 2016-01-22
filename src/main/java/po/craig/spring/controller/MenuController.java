package po.craig.spring.controller;


import po.craig.spring.bean.MenuBean;
import po.craig.spring.service.RoleMenuService;
import po.craig.spring.util.AuthoritiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单
 * Created by wuxf on 15-7-28.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private RoleMenuService roleMenuService = null;

    @RequestMapping(method = RequestMethod.GET)
    public List<MenuBean> getMenus() {
        List<String> roleNames = AuthoritiesUtil.getUserAuthorities();
        return roleMenuService.findMenusByRoleNames(roleNames);
    }
}
