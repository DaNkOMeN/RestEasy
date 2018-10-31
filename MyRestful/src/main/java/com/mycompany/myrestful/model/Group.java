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
public class Group {
    @Column(name = "listOfStudent")
    @NotNull(message = "Need list of student")
    private Map<Integer, Student> listOfStudent;
    
    @Column(name = "nameOfGroup")
    @NotNull(message = "Need name of group")
    private String nameOfGroup;

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
        listOfStudent = new HashMap<Integer, Student>();
    }

    
    
    public Map<Integer, Student> getListOfStudent() {
        return listOfStudent;
    }

    public void setListOfStudent(Map<Integer, Student> listOfStudent) {
        this.listOfStudent = listOfStudent;
    }

    public void setStudent(Student student) {
        int a = listOfStudent.size();
        listOfStudent.put(a, student);
    }

    public Student getStudent(int i) {
        if (listOfStudent.containsKey(i)) {
            return listOfStudent.get(i);
        } else{
            throw new IllegalArgumentException("Несуществующий студент");
        }
    }

}
