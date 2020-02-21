package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin //跨域
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result add(@RequestBody Company company) {
        companyService.add(company);
        return Result.SUCCESS();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Company company) {
        Company one = companyService.findById(id);
        one.setName(company.getName());
        one.setRemarks(company.getRemarks());
        one.setState(company.getState());
        one.setAuditState(company.getAuditState());
        companyService.update(one);
        return Result.SUCCESS();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) {
        companyService.deleteById(id);
        return Result.SUCCESS();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    @GetMapping("")
    public Result findAll() {
        int i = 1 / 0;
        List<Company> companyList = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(companyList);
        return result;
    }

}
