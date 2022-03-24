/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "commands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commands.findAll", query = "SELECT c FROM Commands c"),
    @NamedQuery(name = "Commands.findById", query = "SELECT c FROM Commands c WHERE c.id = :id"),
    @NamedQuery(name = "Commands.findByGroop", query = "SELECT c FROM Commands c WHERE c.groop = :groop"),
    @NamedQuery(name = "Commands.findByCommand", query = "SELECT c FROM Commands c WHERE c.command = :command"),
    @NamedQuery(name = "Commands.findByNameR", query = "SELECT c FROM Commands c WHERE c.nameR = :nameR")})
public class Commands implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "groop")
    private String groop;
    @Basic(optional = false)
    @Column(name = "command")
    private String command;
    @Column(name = "name_r")
    private String nameR;

    public Commands() {
    }

    public Commands(Long id) {
        this.id = id;
    }

    public Commands(Long id, String groop, String command) {
        this.id = id;
        this.groop = groop;
        this.command = command;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroop() {
        return groop;
    }

    public void setGroop(String groop) {
        this.groop = groop;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getNameR() {
        return nameR;
    }

    public void setNameR(String nameR) {
        this.nameR = nameR;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commands)) {
            return false;
        }
        Commands other = (Commands) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entity.Commands[ id=" + id + " ]";
    }
    
}
