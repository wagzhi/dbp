package com.wg.dbp.serivce.impl;

import com.wg.dbp.api.model.User;
import com.wg.dbp.api.model.UserAccount;
import com.wg.dbp.api.service.UserAccountService;
import com.wg.dbp.api.service.UserService;
import com.wg.dbp.dao.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户dbp账号接口
 * @author Paul Wang<wagzhi@qq.com>
 * @since 2020/7/9 5:56 下午
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public UserAccount getUserAccount(String cellphone) {
        User user = userService.getUser(cellphone);
        return userAccountMapper.selectByPrimaryKey(user.getId());
    }
}
