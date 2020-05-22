package com.gyslab.myjasypt.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.gyslab.myjasypt.demo.MyJasyptApplication;

@SpringBootTest
public class PropertyServiceForJasyptStarterTest {
	
	@Autowired
	PropertyServiceForJasyptStarter svc;
	

    @Test
    public void whenDecryptedPasswordNeeded_GetFromService() {
        System.setProperty("jasypt.encryptor.password", "password");
        assertEquals("Password@1", svc.getProperty());
    }
}
