package com.ihrm.company.controller;

import com.ihrm.company.service.CompanyService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CompanyController {

    @Resource
    private CompanyService companyService;
}
