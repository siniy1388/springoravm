/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "vroleforusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vroleforusers.findAll", query = "SELECT v FROM Vroleforusers v"),
    @NamedQuery(name = "Vroleforusers.findById", query = "SELECT v FROM Vroleforusers v WHERE v.id = :id"),
    @NamedQuery(name = "Vroleforusers.findByUserid", query = "SELECT v FROM Vroleforusers v WHERE v.userid = :userid"),
    @NamedQuery(name = "Vroleforusers.findByLogin", query = "SELECT v FROM Vroleforusers v WHERE v.login = :login"),
    @NamedQuery(name = "Vroleforusers.findByRoleid", query = "SELECT v FROM Vroleforusers v WHERE v.roleid = :roleid"),
    @NamedQuery(name = "Vroleforusers.findByRoleNm", query = "SELECT v FROM Vroleforusers v WHERE v.roleNm = :roleNm")})
public class Vroleforusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    private Integer id;
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "login")
    private String login;
    @Column(name = "roleid")
    private Integer roleid;
    @Column(name = "role_nm")
    private String roleNm;

    public Vroleforusers() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getLogin() {
        return login;
    }


    public Integer getRoleid() {
        return roleid;
    }

    public String getRoleNm() {
        return roleNm;
    }
    
      @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vroleforusers)) {
            return false;
        }
        Vroleforusers other = (Vroleforusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Vroleforusers[ id=" + id + " ]";
    }
    
}
