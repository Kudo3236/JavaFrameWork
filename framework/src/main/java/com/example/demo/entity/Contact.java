package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "contacts")
public class Contact {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "姓は必須項目です")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @NotBlank(message = "名は必須項目です")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @NotBlank(message = "メールアドレスは必須項目です")
    @Email(message = "有効なメールアドレスを入力してください")
    @Column(name = "email", nullable = false)
    private String email;
    
    @NotBlank(message = "電話番号は必須項目です")
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @NotBlank(message = "郵便番号は必須項目です")
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    
    @NotBlank(message = "住所は必須項目です")
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "building_name")
    private String buildingName;
    
    @NotBlank(message = "お問い合わせ種別は必須項目です")
    @Column(name = "contact_type", nullable = false)
    private String contactType;
    
    @NotBlank(message = "内容は必須項目です")
    @Column(name = "body", nullable = false)
    private String body;
}








