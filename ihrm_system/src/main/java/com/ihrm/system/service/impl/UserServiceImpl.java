package com.ihrm.system.service.impl;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.system.User;
import com.ihrm.system.dao.UserDao;
import com.ihrm.system.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private IdWorker idWorker;


    @Override
    public User add(User user) {
        String id = idWorker.nextId() + "";
        user.setId(id);
        user.setPassword("123456");
        user.setEnableState(1);
        user.setCreateTime(new Date());
        return userDao.save(user);
    }

    @Override
    public User update(User user) {
        User existuser = userDao.findById(user.getId()).get();
        user.setUsername(existuser.getUsername());
        user.setPassword(existuser.getPassword());
        user.setDepartmentId(existuser.getDepartmentId());
        user.setMobile(existuser.getMobile());
        user.setDepartmentId(existuser.getDepartmentId());
        user.setDepartmentName(existuser.getDepartmentName());
        return userDao.save(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public Page<User> findAll(Map<String, Object> paramsmap, int page, int size) {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isEmpty(paramsmap.get("companyId"))) {
                    Expression<String> companyId = root.get("companyId").as(String.class);
                    list.add(criteriaBuilder.equal(companyId, paramsmap.get("companyId")));
                }
                if (!StringUtils.isEmpty(paramsmap.get("departmentId"))) {
                    Expression<String> departmentId = root.get("departmentId").as(String.class);
                    list.add(criteriaBuilder.equal(departmentId, paramsmap.get("departmentId")));
                }
                //是否分配部门 0未分配  1已分配
                if (StringUtils.isEmpty(paramsmap.get("departmentId")) || ((String) paramsmap.get("hasDept")).equals("0")) {
                    Expression<String> departmentId = root.get("departmentId").as(String.class);
                    list.add(criteriaBuilder.isNull(departmentId));
                } else {
                    Expression<String> departmentId = root.get("departmentId").as(String.class);
                    list.add(criteriaBuilder.isNotNull(departmentId));
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        //Page<User> all = userDao.findAll(specification, new PageRequest(page-1, size)); 废弃
        return userDao.findAll(specification, PageRequest.of(page - 1, size));
    }
}
