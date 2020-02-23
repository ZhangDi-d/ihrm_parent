package com.ihrm.company.service.impl;

import com.ihrm.common.service.BaseService;
import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseService<Department> implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private IdWorker idWorker;

    @Override
    public void add(Department department) {
        department.setId(idWorker.nextId() + "");
        department.setCreateTime(new Date());
        departmentDao.save(department);
    }

    @Override
    public void update(Department department) {
        Department sourceDepartment = departmentDao.findById(department.getId()).get();
        sourceDepartment.setName(department.getName());
        sourceDepartment.setPid(department.getPid());
        sourceDepartment.setManagerId(department.getManagerId());
        sourceDepartment.setIntroduce(department.getIntroduce());
        sourceDepartment.setManager(department.getManager());
        departmentDao.save(sourceDepartment);
    }

    @Override
    public Department findById(String id) {
        return departmentDao.findById(id).get();
    }

    @Override
    public void delete(String id) {
        departmentDao.deleteById(id);
    }

    @Override
    public List<Department> findAll(String companyId) {
        return departmentDao.findAll(getSpec(companyId));
    }

}
