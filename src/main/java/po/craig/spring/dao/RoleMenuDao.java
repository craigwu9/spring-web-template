package po.craig.spring.dao;

import po.craig.spring.domain.RoleMenu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 角色菜单对应关系
 * Created by wuxf on 15-10-14.
 */
public interface RoleMenuDao extends PagingAndSortingRepository<RoleMenu, Long> {

    @Query("from #{#entityName} u where u.role.roleName in :roleNames order by menu.parentId, menu.sequence")
    List<RoleMenu> findByRoleNames(@Param("roleNames") List<String> roleNames);
}
