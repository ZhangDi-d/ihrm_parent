package com.ihrm.company.service;

import com.ihrm.domain.company.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * 添加部门
     */
    public void add(Department department);

    /**
     * 更新部门信息
     */
    public void update(Department department);

    /**
     * 根据ID获取部门信息
     *
     * @param id 部门ID
     * @return 部门信息
     */
    public Department findById(String id);

    /**
     * 删除部门
     *
     * @param id 部门ID
     */
    public void delete(String id);

    /**
     * 获取部门列表
     */
    public List<Department> findAll(String companyId);
}
