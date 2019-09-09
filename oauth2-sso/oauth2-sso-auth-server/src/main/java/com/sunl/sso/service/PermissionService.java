package com.sunl.sso.service;

import com.sunl.sso.entity.SysPermission;

import java.util.List;


public interface PermissionService {

    List<SysPermission> findByUserId(Integer userId);

}
