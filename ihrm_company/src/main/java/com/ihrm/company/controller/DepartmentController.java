package com.ihrm.company.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.response.DeptListResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/company")
public class DepartmentController extends BaseController {

    @Resource
    private DepartmentService departmentService;
    @Resource
    private CompanyService companyService;


    @PostMapping("/department")
    public Result save(@RequestBody Department department) {
        //设置成固定值1
        department.setCompanyId(companyId);
        departmentService.add(department);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 修改部门信息
     */
    @PutMapping("/department/{id}")
    public Result update(@PathVariable(name = "id") String id, @RequestBody Department
            department) throws Exception {
        department.setCompanyId(companyId);
        department.setId(id);
        departmentService.update(department);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/department/{id}")
    public Result delete(@PathVariable(name = "id") String id) throws Exception {
        departmentService.delete(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据id查询
     */
    @GetMapping("/department/{id}")
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS, department);
    }

    @GetMapping("/department")
    public Result findAll() throws Exception {
        Company company = companyService.findById(companyId);
        List<Department> list = departmentService.findAll(companyId);
        return new Result(ResultCode.SUCCESS, new DeptListResult(company, list));
    }
}
