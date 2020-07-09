package com.wg.dbp.api.service;

import com.wg.dbp.api.model.User;

/**
 * 用户接口
 * @author Paul Wang<wagzhi@qq.com>
 * @since 2020/7/9 5:15 下午
 */
public interface UserService {
    User addUser(String cellphone);

    User getUser(String cellphone);
}
