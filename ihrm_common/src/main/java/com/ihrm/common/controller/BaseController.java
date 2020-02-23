package com.ihrm.common.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    protected HttpServletRequest httpServletRequest;
    protected HttpServletResponse httpServletResponse;
    protected String companyId;
    protected String companyName;

    /**
     * @ModelAttribute最主要的作用是将数据添加到模型对象中，用于视图页面展示时使用。 @ModelAttribute等价于 model.addAttribute(" attributeName ", abc);
     */
    @ModelAttribute
    public void setResAndReq(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String companyId, String companyName) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.companyId = "1";
        this.companyName = "alibaba";
    }
}
