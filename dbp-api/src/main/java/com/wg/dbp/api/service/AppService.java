package com.wg.dbp.api.service;

import com.wg.dbp.api.model.App;

/**
 * @author Paul Wang<wagzhi@qq.com>
 * @since 2020/7/9 6:37 下午
 */
public interface AppService {
    App getApp(String appId);
}
