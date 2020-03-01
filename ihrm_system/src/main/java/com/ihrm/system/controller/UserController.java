package com.ihrm.system.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.PageResult;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.domain.system.User;
import com.ihrm.system.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/sys")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @PostMapping("/user")
    public Result save(@RequestBody User user) {
        //设置成固定值1
        user.setCompanyId(companyId);
        user.setCompanyId(companyName);
        userService.add(user);
        return new Result(ResultCode.SUCCESS);
    }

    @PutMapping("/user/{id}")
    public Result update(@PathVariable(name = "id") String id, @RequestBody User user) {
        user.setId(id);
        userService.update(user);
        return new Result(ResultCode.SUCCESS);
    }

    @DeleteMapping("/user/{id}")
    public Result delete(@PathVariable(name = "id") String id) {
        userService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping("/user/{id}")
    public Result findById(@PathVariable(name = "id") String id) {
        User user = userService.findById(id);
        return new Result(ResultCode.SUCCESS, user);
    }

    @GetMapping("/user")
    public Result findAll(int page, int size, @RequestParam Map map) {
        map.put("companyId",companyId);
        Page users = userService.findAll(map, page, size);
        PageResult<User> result = new PageResult<>();
        result.setRows(users.getContent());
        result.setTotal(users.getTotalElements());
        return new Result(ResultCode.SUCCESS, result);
    }
}
