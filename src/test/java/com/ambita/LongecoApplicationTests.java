package com.ambita;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ambita.service.PasswordService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LongecoApplicationTests {

  @Autowired
  private
  PasswordService passwordService;

  @Test
  public void contextLoads() {
    passwordService.requestToSetNewPassword("frode.borlaug@gmail.com");
  }
}