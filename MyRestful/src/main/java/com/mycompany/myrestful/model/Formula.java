/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myrestful.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author danko
 */

public class Formula {
    @NotNull(message = "Хз что написать")
    @Size(min = 4, message = "Должно быть больше 4")
    private String form;

//    
//    @NotNull(message = "Тоже хз что написать")
//    private List<String> alist;
   
    
    public Formula() {
    }

//    public Formula(String form, List<String> alist) {
//        this.form = form;
//        this.alist = alist;
//    }
    public Formula(String form){
        this.form = form;
    }
    
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

//    public void setStringToArray(String str){
//        alist.add(str);
//    }
//    
//    public String getStringOfArray(int i){
//        return alist.get(i);
//    }
    
}
