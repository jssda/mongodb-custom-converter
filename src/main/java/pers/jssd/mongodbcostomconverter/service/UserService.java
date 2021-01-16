package pers.jssd.mongodbcostomconverter.service;

import pers.jssd.mongodbcostomconverter.entity.pojo.User;

import java.util.List;

/**
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 14:35
 */
public interface UserService {

    /**
     * 存储一个用户
     *
     * @param user 需要存储的用户
     * @return 返回添加的用户id
     */
    String saveUser(User user);

    /**
     * 查询一个用户信息
     *
     * @param id 用户id
     * @return 返回查询到的用户信息, 如果没有查询到, 返回null
     */
    User getOne(String id);

    /**
     * 查询全部的用户信息
     *
     * @return 返回查询出来的用户列表
     */
    List<User> listUser();

}
