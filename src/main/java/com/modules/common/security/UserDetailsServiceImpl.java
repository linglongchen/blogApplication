package com.modules.common.security;

import com.modules.system.dbEntity.SysUserDB;
import com.modules.system.entity.SysRole;
import com.modules.system.entity.SysUser;
import com.modules.system.entity.SysUserRole;
import com.modules.system.service.SysRoleService;
import com.modules.system.service.SysUserRoleService;
import com.modules.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author v_vllchen
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = userService.findByUserName(username);
        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        List<SysUserRole> userRoles = sysUserRoleService.listByUserId(user.getId());
        for (SysUserRole userRole : userRoles) {
            SysRole role = sysRoleService.get(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        // 返回UserDetails实现类
        return new SecurityUser(user.getUsername(), user.getPassword(), authorities);
    }
}
