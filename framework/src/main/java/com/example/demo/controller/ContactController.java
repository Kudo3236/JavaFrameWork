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

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@Controller
@RequestMapping("/admin/contacts")

public class ContactController {
	
    @Autowired
    private ContactService contactService;
    
    // 新規お問い合わせ作成画面
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact()); // 空のContactオブジェクトをフォームに渡す
        return "contacts/new";
    }
    
    // 新規お問い合わせ作成処理
    @PostMapping
    public String createContact(@ModelAttribute @Valid Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // バリデーションエラーがあればフォームに戻る
            return "contacts/new";
        }
        
        contactService.saveContact(contact); // サービスで保存処理
        return "redirect:/admin/contacts";
    }
    
    // お問い合わせ一覧表示
    @GetMapping
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactService.findAllContacts());
        return "contacts/index";
    }
}