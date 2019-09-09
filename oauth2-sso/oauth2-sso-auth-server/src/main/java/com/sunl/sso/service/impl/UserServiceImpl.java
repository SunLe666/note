package com.sunl.sso.service.impl;

import com.sunl.sso.entity.SysUser;
import com.sunl.sso.repository.SysUserRepository;
import com.sunl.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunl
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser getByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
