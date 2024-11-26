package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService {
	
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void saveAdmin(Admin admin) {
    	
        // パスワードを暗号化
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin); // データベースに保存
    }
}