/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myrestful.model;

import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author danko
 */
public class TestForRest {
    @NotNull
    @Size(min = 3, message = "Less that 3 simbol")
    private String someShit;
    private ArrayList<String> someOtherShit;
    
    public TestForRest(String someshit) {
        this.someShit = someshit;
        someOtherShit = new ArrayList<String>();
    }

    public String getSomeShit() {
        return someShit;
    }

    public void setSomeShit(String someShit) {
        this.someShit = someShit;
    }

    public ArrayList<String> getSomeOtherShit() {
        return someOtherShit;
    }

    public void setSomeOtherShit(String someMyShit) {
        this.someOtherShit.add(someMyShit);
    }
    
    
}
