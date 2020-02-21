package com.ihrm.company;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class CompanyDaoTest extends AbstractTest {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;

    @Test
    public void test1() {
        Optional<Company> byId = companyDao.findById("1");
        if (byId.isPresent()) {
            Company company = byId.get();
            System.out.println(company);
        }

        // companyDao.save(company)； 有id更新，无id新增
        // companyDao.deleteById(byId); 删除
    }

    @Test
    public void test2() {
        Company company = new Company();
        company.setId(idWorker.nextId() + "");
        company.setCreateTime(new Date());
        company.setState(1); //启用
        company.setAuditState("0"); //待审核
        company.setBalance(0d);
        company.setName("ceshi gon si ");
        company.setManagerId("123");
        companyDao.save(company);


    }
}
