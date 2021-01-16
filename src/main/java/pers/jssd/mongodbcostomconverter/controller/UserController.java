package pers.jssd.mongodbcostomconverter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pers.jssd.mongodbcostomconverter.entity.bean.Result;
import pers.jssd.mongodbcostomconverter.entity.pojo.User;
import pers.jssd.mongodbcostomconverter.service.UserService;

import java.util.List;

/**
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 14:31
 */
@Slf4j
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @PostMapping
    public Result<?> saveUser(@RequestBody User user) {
        String s = userService.saveUser(user);
        return Result.success(s);
    }

    @GetMapping("/{id}")
    public Result<User> getOne(@PathVariable String id) {
        User user = userService.getOne(id);
        return Result.success(user);
    }

    @GetMapping
    public Result<List<User>> listUser() {
        List<User> list = userService.listUser();
        return Result.success(list);
    }

}
