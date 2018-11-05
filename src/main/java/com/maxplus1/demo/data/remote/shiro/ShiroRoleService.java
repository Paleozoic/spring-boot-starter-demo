package com.maxplus1.demo.data.remote.shiro;

import com.maxplus1.access.starter.config.shiro.rbac.ShiroRole;
import com.maxplus1.access.starter.config.shiro.rbac.ShiroUser;
import com.maxplus1.access.starter.config.shiro.rbac.service.IShiroRoleService;
import com.maxplus1.access.starter.config.shiro.rbac.service.IShiroUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiroRoleService implements IShiroRoleService {
    @Override
    public List<ShiroRole> getUserRoleList(String userId) {
        return null;
    }
}
