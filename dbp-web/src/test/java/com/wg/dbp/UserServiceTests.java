package com.wg.dbp;

import com.wg.dbp.api.model.User;
import com.wg.dbp.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DbpWebApplication.class)
@Transactional
class UserServiceTests {

    @Autowired
    private UserService userService;


    @Test
    void testAddUser() {
        User user = userService.addUser("18658859571");
        assertEquals("18658859571",user.getCellphone());
    }

}
