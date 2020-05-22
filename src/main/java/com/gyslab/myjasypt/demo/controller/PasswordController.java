package com.gyslab.myjasypt.demo.controller;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyslab.myjasypt.demo.model.PasswordEncryptRequest;
import com.gyslab.myjasypt.demo.model.PasswordEncryptResponse;

@RestController
@RequestMapping(value = "/api/password")
public class PasswordController {
	
	@Autowired
	@Qualifier(value = "encryptorBean")
	StringEncryptor encryptor;
	
	@PostMapping(value = "/encrypt")
	public PasswordEncryptResponse encrypt(@RequestBody PasswordEncryptRequest data) {
		return new PasswordEncryptResponse(encryptor.encrypt(data.getData()));
	}
	
	@PostMapping(value = "/decrypt")
	public PasswordEncryptResponse decrypt(@RequestBody PasswordEncryptRequest data) {
		return new PasswordEncryptResponse(encryptor.decrypt(data.getData()));
	}
	
	
	
	
}
