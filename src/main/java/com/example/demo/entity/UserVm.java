/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oleg
 */
@Entity
@Table(name = "user_vm")
@XmlRootElement
@NamedQueries({ 
    @NamedQuery(name = "UserVm.findAll", query = "SELECT u From UserVm  u"),
    @NamedQuery(name = "UserVm.findByName", query = "SELECT u FROM UserVm u WHERE u.name = :name"),
    @NamedQuery(name = "UserVm.findByNameVm", query = "SELECT u FROM UserVm u WHERE u.nameVm = :name_vm"),
    @NamedQuery(name = "UserVm.findByCdvmSystem", query = "SELECT u FROM UserVm u WHERE u.cdvmSystem = :cdvm_system"),
    @NamedQuery(name = "UserVm.findByUserid", query = "SELECT u FROM UserVm u WHERE u.userid = :userid"),
    @NamedQuery(name = "UserVm.findByCdvm", query = "SELECT u FROM UserVm u WHERE u.cdvm = :cdvm")})
public class UserVm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "name_vm")
    private String nameVm;
    @Column(name = "cdvm_system")
    private String cdvmSystem;
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "cdvm")
    private Integer cdvm;
    

    public UserVm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameVm() {
        return nameVm;
    }

    public void setNameVm(String nameVm) {
        this.nameVm = nameVm;
    }

    public String getCdvmSystem() {
        return cdvmSystem;
    }

    public void setCdvmSystem(String cdvmSystem) {
        this.cdvmSystem = cdvmSystem;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCdvm() {
        return cdvm;
    }

    public void setCdvm(Integer cdvm) {
        this.cdvm = cdvm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
