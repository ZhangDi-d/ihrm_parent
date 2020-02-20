package com.ihrm.company;

import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CompanyDaoTest extends AbstractTest {

    @Autowired
    private CompanyDao companyDao;

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
}
