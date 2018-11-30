/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myrestful.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danko
 */
public class MyGroup {
     private String name;
    private List<Student> list;
   

    public MyGroup(List<Student> list) {
        this.list = list;
    }
 
    public MyGroup() {
        list = new ArrayList<Student>();
    }
    
    
    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
    
    public void setString(Student string){
        list.add(string);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public MyGroup(String name, ArrayList<Student> list){
        this.list = list;
        this.name = name;
    }
    
    public Student getStudent(int i){
        return list.get(i);
    }
    
    
}
