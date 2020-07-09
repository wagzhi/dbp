package com.wg.dbp.api.service;

import com.wg.dbp.api.model.DbpTransaction;

/**
 * dbp转账交易接口
 *  @author Paul Wang<wagzhi@qq.com>
 *  @since 2020/7/9 5:16 下午
 */
public interface DbpTransactionService {
    /**
     * 创建交易,并发送交易手机验证码给转出手机号
     * @param fromCellphone
     * @param toCellphone
     * @param value
     * @param memo
     * @param appId
     * @param timestamp
     * @param sign
     * @return
     */
    DbpTransaction create(String fromCellphone, String toCellphone, float value, String memo, String appId, int timestamp, String sign);

    /**
     * 根据验证码确认交易
     * @param transactionId
     * @param code
     * @return
     */
    DbpTransaction confirm(String transactionId, String code);
}
