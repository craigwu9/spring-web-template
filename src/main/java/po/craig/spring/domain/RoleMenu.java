package po.craig.spring.domain;

import javax.persistence.*;

/**
 * 角色菜单对应关系
 * Created by wuxf on 15-10-14.
 */
@Entity(name="mng_role_menu")
public class RoleMenu {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name="menu_id")
    private Menu menu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
