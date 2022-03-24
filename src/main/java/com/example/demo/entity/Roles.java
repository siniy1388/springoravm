package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "role_nm", nullable = false)
    private String roleNm;

    @Lob
    @Column(name = "role_rus")
    private String roleRus;

    public String getRoleRus() {
        return roleRus;
    }

    public void setRoleRus(String roleRus) {
        this.roleRus = roleRus;
    }

    public String getRoleNm() {
        return roleNm;
    }

    public void setRoleNm(String roleNm) {
        this.roleNm = roleNm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}