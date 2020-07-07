package com.wg.dbp.common;

/**
 * 用户错误，编码10000-20000
 * @author Paul Wang<wagzhi@qq.com>
 * @since  2020/7/6
 */
public enum UserErrorEnum implements BizError {

    //用户错误 100-800
    LoginError(10000, "用户名或密码错误！"),
    LoginErrorTooManyTimes(10001, "登陆错误次数过多，请15分钟后再试！"),
    UserNotExist(10002, "用户不存在！"),
    CellphoneNotExist(10003, "手机号码不存在！"),
    InvalidCode(10004, "无效的验证码！"),
    NoAthorization(10005, "无用户权限！"),
    InvalidAccessToken(10006, "未登录或已过期！"),
    CellphoneUserExist(10007, "该手机号已经被注册！"),
    UserAreadyHasCellphone(10008, "该用户已经绑定过手机！"),
    UsernameExists(10009, "用户名已经存在"),
    ChangePwdFail(10010, "修改密码失败，请重试！"),
    CellphoneIsExist(10013, "手机号码已经被注册"),
    NameIsTooLong(10014, "字符不能超过30个字");


    private int errno;
    private String errmsg;

    UserErrorEnum(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public String getErrmsg() {
        return errmsg;
    }
}
