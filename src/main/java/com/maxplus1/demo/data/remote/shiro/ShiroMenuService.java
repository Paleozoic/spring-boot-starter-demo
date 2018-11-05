package com.maxplus1.demo.data.remote.shiro;

import com.maxplus1.access.starter.config.shiro.rbac.ShiroMenu;
import com.maxplus1.access.starter.config.shiro.rbac.ShiroUser;
import com.maxplus1.access.starter.config.shiro.rbac.service.IShiroMenuService;
import com.maxplus1.access.starter.config.shiro.rbac.service.IShiroUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiroMenuService implements IShiroMenuService {

    @Override
    public List<ShiroMenu> getUserMenuList(String userId) {
        return null;
    }
}
