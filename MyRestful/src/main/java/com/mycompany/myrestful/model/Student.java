/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myrestful.model;


import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danko
 */

public class Student {
    //@Column(name = "firstname")
    @NotNull(message = "Need firstname")
    private String firstname;
    
    //@Column(name = "secondname")
    @NotNull(message = "Need lastname")
    private String secondname;
    
    //@Column(name = "nameOfGroup")
    @NotNull(message = "Need group")
    private String nameOfGroup;

    public Student(String firstname, String lastname, String nameOfGroup) {
        this.firstname = firstname;
        this.secondname = lastname;
        this.nameOfGroup = nameOfGroup;
    }

    public Student() {
    }


    
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return secondname;
    }

    public void setLastname(String lastname) {
        this.secondname = lastname;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }
    
    
    
}
