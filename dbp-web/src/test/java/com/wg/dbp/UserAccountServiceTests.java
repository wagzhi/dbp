package com.wg.dbp;

import com.wg.dbp.api.model.UserAccount;
import com.wg.dbp.api.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Paul Wang<wagzhi@qq.com>
 * @since 2020/7/9 5:54 下午
 */
@SpringBootTest(classes = {DbpWebApplication.class})
@Transactional
public class UserAccountServiceTests {
    @Autowired
    private UserAccountService userAccountService;

    @Test
    void testGetUserAccount(){
        String cellphone = "13300000000";
        UserAccount userAccount = userAccountService.getUserAccount(cellphone);
        assertEquals(10000.00,userAccount.getBalance());
        assertEquals(1,userAccount.getUid());
    }
}
