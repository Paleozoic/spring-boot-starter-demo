package com.maxplus1.demo.data.service.shiro;

import com.maxplus1.access.starter.config.shiro.rbac.ShiroMenu;
import com.maxplus1.access.starter.config.shiro.rbac.ShiroRole;
import com.maxplus1.access.starter.config.shiro.rbac.ShiroUser;
import com.maxplus1.access.starter.config.shiro.rbac.service.IShiroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiroService implements IShiroService {

    @Override
    public List<ShiroMenu> getUserMenuList(String userId) {
        return null;
    }

    @Override
    public List<ShiroRole> getUserRoleList(String userId) {
        return null;
    }

    @Override
    public ShiroUser getUserByNameWithPassword(String userName) {
        return null;
    }
}
