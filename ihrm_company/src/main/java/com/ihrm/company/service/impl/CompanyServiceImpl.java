package com.ihrm.company.service.impl;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyDao companyDao;
    @Resource
    private IdWorker idWorker;


    @Override
    public Company add(Company company) {
        String id = idWorker.nextId() + "";
        company.setId(id);
        company.setCreateTime(new Date());
        company.setState(1); //启用
        company.setAuditState("0"); //待审核
        company.setBalance(0d);
        return companyDao.save(company);

    }

    public Company update(Company company) {
        return companyDao.save(company);
    }

    public Company findById(String id) {
        return companyDao.findById(id).get();
    }

    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }
}
