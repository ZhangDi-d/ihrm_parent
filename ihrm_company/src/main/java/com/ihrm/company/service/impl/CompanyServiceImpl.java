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
        company.setCreateTime(new Date());
        company.setState(1); //启用
        company.setAuditState("0"); //待审核
        company.setBalance(0d);
        return companyDao.save(company);

    }

    @Override
    public Company update(Company company) {
        return null;
    }

    @Override
    public Company findById(String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Company> findAll() {
        return null;
    }
}
