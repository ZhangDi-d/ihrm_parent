package com.ihrm.system.service;

import com.ihrm.domain.system.Role;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleService {

    public void assignPerms(String roleId, List<String> permIds);

    public void save(Role role);

    public void update(Role role);

    public Role findById(String id);

    public List<Role> findAll(String companyId);

    public void delete(String id);

    public Page<Role> findByPage(String companyId, int page, int size);
}

