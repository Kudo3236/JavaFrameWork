package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {
	
    @Autowired
    private ContactRepository contactRepository;
    
    // お問い合わせ保存
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }
    
    // お問い合わせ一覧取得
    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }
}