package org.teamdai.sivoleivsc;

import BackEnd.ListOfUsers;
import BackEnd.User;
import BackEnd.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBaseTest {


    private UserRepository userRepository;

    @Test
    public void testFindById() {
        Collection<User> user = userRepository.findById(1L);
        assertFalse(user.isEmpty());
        assertEquals("John Doe", user.getClass().getName());
    }





}
