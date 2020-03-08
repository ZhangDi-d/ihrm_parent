package com.ihrm.system.service;

import com.ihrm.domain.system.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User add(User user);

    public User update(User user);

    public User findById(String id);

    public void deleteById(String id);

    public Page<User> findAll(Map<String, Object> paramsmap, int page, int size);

    void assignRoles(String userId, List<String> roleIds);

    User findByMobile(String mobile);
}
