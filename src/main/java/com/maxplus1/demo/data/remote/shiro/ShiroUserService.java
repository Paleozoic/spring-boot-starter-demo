package com.maxplus1.demo.data.remote.shiro;

import com.maxplus1.access.starter.config.shiro.rbac.ShiroUser;
import com.maxplus1.access.starter.config.shiro.rbac.service.IShiroUserService;
import org.springframework.stereotype.Service;

@Service
public class ShiroUserService implements IShiroUserService{
    @Override
    public ShiroUser getUserByNameWithPassword(String userName) {
        return null;
    }
}
