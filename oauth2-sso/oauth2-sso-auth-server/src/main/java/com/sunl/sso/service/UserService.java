package com.sunl.sso.service;

import com.sunl.sso.entity.SysUser;

public interface UserService {

    SysUser getByUsername(String username);
}
