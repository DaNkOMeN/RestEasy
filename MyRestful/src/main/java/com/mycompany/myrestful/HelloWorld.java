/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myrestful;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.myrestful.model.ErrorClass;
import com.mycompany.myrestful.model.Formula;
import com.mycompany.myrestful.model.Group;
import com.mycompany.myrestful.model.Student;
import com.mycompany.myrestful.model.TestArray;
import com.mycompany.myrestful.model.TestInt;
import com.mycompany.myrestful.model.University;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;

/**
 *
 * @author danko
 */
@Path("/")
public class HelloWorld {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    public static void main(String[] args){
////        University rsatu = new University("Rsatu");
////        Group ipb15 = new Group("ipb-15");
////        Student danya = new Student("Danya","Golovkin","Ipb-15");
////        Student tanya = new Student("Tanya","Potekunova","Ipb-15");
////        ipb15.setStudent(danya);
////        ipb15.setStudent(tanya);
////        rsatu.setGroup("ipb-15", ipb15);
////        
////        JSONObject object = new JSONObject(rsatu);
////        log(object);
//
//          Formula test = new Formula("kek");
          TestArray test = new TestArray();
          test.setString("mama");
          test.setString("papa");
          String json = GSON.toJson(test);
         System.out.println(json);
          
    }
    
   
    
    @GET
    @Path("helloworld")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloworld(){
        return "Hello world";
    }
    
    @GET
    @Path("helloname/{name}")
    public String hello(@PathParam("name") final String name) {
      return "Hello " +name;
    }
    
   
    @POST
    @Path("danko")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Formula myMethod(Formula test){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Formula>> constraintViolation = validator.validate(test);
        StringBuilder builder = new StringBuilder();
        for (ConstraintViolation<Formula> cv : constraintViolation)
        builder.append(String.format("Внимание, ошибка! property: [%s], value: [%s], message: [%s]",  cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        String mystring = builder.toString();
        test.setForm(mystring + "govno");
        return test;
    }
       
    
    
  @POST
  @Path("example")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_XML) 
  public TestArray intMethod(TestArray test){
//      int k = test.();
//      k++;
//      test.setForm(k);
      return test;
  }
    
    
    
    
    
    @POST
    @Path("arif")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Formula count(Formula form){
        String a = form.getForm();
        char[] ch = a.toCharArray();
        String str1 = "";
        String str2 = "";
        String operator = "";
        char charTmp = ' ';
        int count = 0;
        int countFirst = 0;
        int countSecond = 0;
        double x = 0;
        double y = 0;
        String b = " ";
        
        while (count < ch.length - 1){
            char c = ch[countFirst];

            if(Character.isDigit(c)){
                String strTmp = Character.toString(c);
                str1 = str1.concat(strTmp);
                x = Double.parseDouble(str1);
                countFirst++;
                count++;
                countSecond++;

            } else {
                countSecond++;
                count = countSecond;

                charTmp = c;
                operator = Character.toString(charTmp);

                char c2 = ch[countSecond];

                if(Character.isDigit(c2)){
                    String strTmp = Character.toString(c2);
                    str2 = str2.concat(strTmp);
                    y = Double.parseDouble(str2);
                }
            }
        }
        if (operator.equals("*")){
           b = Double.toString(x * y);
        }
        if (operator.equals("/")){
            b = Double.toString(x / y);
        }
        if (operator.equals("+")){
            b = Double.toString(x + y);
        }
        if (operator.equals("-")){
            b = Double.toString(x - y);
        }
        
        form.setForm(b);
        return form;
    }
    
    
    
 }
