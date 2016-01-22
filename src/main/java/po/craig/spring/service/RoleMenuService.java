package po.craig.spring.service;

import po.craig.spring.bean.MenuBean;
import po.craig.spring.dao.RoleMenuDao;
import po.craig.spring.domain.Menu;
import po.craig.spring.domain.RoleMenu;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色和菜单对应关系
 * Created by wuxf on 15-10-14.
 */
@Service
public class RoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao = null;

    private void addToMenuBeanList(List<MenuBean> menuBeanList1, Menu menu) {
        for(MenuBean menuBean: menuBeanList1) {
            if (menuBean.getId().equals(menu.getParentId())) {
                if (menuBean.getChildren() == null) {
                    menuBean.setChildren(new ArrayList<MenuBean>());
                }
                MenuBean newMenuBean = new MenuBean();
                BeanUtils.copyProperties(menu, newMenuBean);
                menuBean.getChildren().add(newMenuBean);
            } else {
                if (menuBean.getChildren() != null && menuBean.getChildren().size() > 0) {
                    addToMenuBeanList(menuBean.getChildren(), menu);
                }
            }
        }
    }

    public List<MenuBean> findMenusByRoleNames(List<String> roleNames) {
        final List<MenuBean> menuBeanList = new ArrayList<MenuBean>();

        List<RoleMenu> roleMenus = roleMenuDao.findByRoleNames(roleNames);

        for(RoleMenu roleMenu : roleMenus) {
            Menu menu = roleMenu.getMenu();
            if (menu.getParentId() == null || menu.getParentId() == -1l) {
                MenuBean menuBean = new MenuBean();
                BeanUtils.copyProperties(menu, menuBean);
                menuBeanList.add(menuBean);
            } else {
                addToMenuBeanList(menuBeanList, menu);
            }
        }

        return menuBeanList;
    }
}
