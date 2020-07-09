package com.wg.dbp.serivce.impl;

import com.wg.dbp.api.model.User;
import com.wg.dbp.api.model.example.UserExample;
import com.wg.dbp.api.service.UserService;
import com.wg.dbp.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Paul Wang<wagzhi@qq.com>
 * @since 2020/7/9 5:41 下午
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 默认为中国大陆手机号
     */
    private static final String DEFAULT_AREA_CODE = "86";

    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(String cellphone) {
        User user = new User();
        user.setCellphone(cellphone);
        int result = userMapper.insertSelective(user);
        if(result > 0){
            return userMapper.selectByPrimaryKey(user.getId());
        }else{
            return null;
        }
    }

    @Override
    public User getUser(String cellphone){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andCellphoneEqualTo(cellphone).andAreaCodeEqualTo(DEFAULT_AREA_CODE).andDeletedEqualTo(false);
        return userMapper.selectOneByExample(userExample);
    }
}
