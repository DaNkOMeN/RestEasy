/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myrestful.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danko
 */
public class University {
    @Column(name = "arrayOfGroup")
    @NotNull(message = "Need arrayOfGroup")
    private Map<String,Group> arrayOfGroup;
    
    @Column(name = "nameOfUnivervity")
    @NotNull(message = "Need nameOfUniversity")
 //   @Size(min = 3)
    private String nameOfUniversity;

    public University(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
        arrayOfGroup = new HashMap<String,Group>();
    }

    public Map<String, Group> getArrayOfGroup() {
        return arrayOfGroup;
    }

    public void setArrayOfGroup(Map<String, Group> university) {
        this.arrayOfGroup = university;
    }
    
    public void setGroup(String nameOfGroup, Group group){
        if (!arrayOfGroup.containsKey(nameOfGroup)){
            arrayOfGroup.put(nameOfGroup,group);
        } else {
            throw new IllegalArgumentException("Существует такая группа");
        }
    }
    
    public Group getGroup(String nameOfGroup){
        if (arrayOfGroup.containsKey(nameOfGroup)) {
            return arrayOfGroup.get(nameOfGroup);
        } else{
            throw new IllegalArgumentException("Несуществующая группа");
        }
    }
    
}
