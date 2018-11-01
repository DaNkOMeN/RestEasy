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
public class TestArray {
    private List<String> list;

    public TestArray(List<String> list) {
        this.list = list;
    }
 
    public TestArray() {
        list = new ArrayList<String>();
    }
    
    
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
    public void setString(String string){
        list.add(string);
    }
}
