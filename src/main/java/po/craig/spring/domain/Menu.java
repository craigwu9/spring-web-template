package po.craig.spring.domain;

import javax.persistence.*;

/**
 * 菜单实例
 * Created by wuxf on 15-7-28.
 */
@Entity(name="mng_menu")
public class Menu {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_path")
    private String menuPath;

    @Column(name="parent_id")
    private Long parentId;
    
    @Column(name="sequence")
    private int sequence;

    @Column(name="menuClass")
    private String menuClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }


}
