package com.ihrm.company.service;

import com.ihrm.domain.company.Company;

import java.util.List;


public interface CompanyService {
    public Company add(Company company);

    public Company update(Company company);

    public Company findById(String id);

    public void deleteById(String id);

    public List<Company> findAll();
}
