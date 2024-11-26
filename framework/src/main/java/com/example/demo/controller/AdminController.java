package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    private AdminService adminService;
    
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("admin", new Admin()); // 空のAdminオブジェクトを渡す
        return "admin/signup";
    }
    @PostMapping("/signup")
    public String processSignup(@ModelAttribute @Valid Admin admin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // バリデーションエラーがあればフォームに戻る
            return "admin/signup";
        }
        
        adminService.saveAdmin(admin); // サービスで保存
        return "redirect:/admin/signin";
    }
    
    @GetMapping("/signin")
    public String showSigninForm() {
        return "admin/signin";
    }
}