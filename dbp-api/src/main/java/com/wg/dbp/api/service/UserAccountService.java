package com.wg.dbp.api.service;

import com.wg.dbp.api.model.UserAccount;

/**
 * 用户dbp账号接口
 * @author Paul Wang<wagzhi@qq.com>
 * @since 2020/7/9 5:16 下午
 */
public interface UserAccountService {
    UserAccount getUserAccount(String cellphone);
}
