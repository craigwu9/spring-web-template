package po.craig.spring.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 权限工具
 * Created by wuxf on 15-10-21.
 */
public class AuthoritiesUtil {
    /**
     * 获取当前用户的角色
     * @return 获取当前用户角色
     */
    public static List<String> getUserAuthorities() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        List<String> roleNames = new ArrayList<>();
        for(GrantedAuthority grantedAuthority : authorities) {
            roleNames.add(grantedAuthority.getAuthority());
        }
        return roleNames;
    }

    public static String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
