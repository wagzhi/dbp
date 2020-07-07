package com.wg.dbp.common;
/**
 * 业务异常，该类异常一般代码中无需处理，由接口统一返回对应错误信息
 * @author Paul Wang<wagzhi@qq.com>
 * @since  2020/7/6
 */
public class BizException extends RuntimeException{
    private BizError error;


    public BizException(BizError err) {
        this.error = err;
    }

    public BizException(UserErrorEnum err, Exception e) {
        super(err.getErrmsg(),e);
        this.error = err;
    }
}
