/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myrestful.model;

import java.util.List;



/**
 *
 * @author danko
 */
public class University {
    private String name;
    private List<MyGroup> list;

    public University(String name, List<MyGroup> list) {
        this.name = name;
        this.list = list;
    }
    
}
