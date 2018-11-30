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
import com.mycompany.myrestful.model.Student;
import com.mycompany.myrestful.model.MyGroup;
import com.mycompany.myrestful.model.TestInt;
import com.mycompany.myrestful.model.University;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
       
    }
   
   
    
    
    
    
  
    
    public static void forth(){
        Student danya = new Student("Danya", "Golovkin", "ipb-15");
        JSONObject object = new JSONObject(danya);
        String json = GSON.toJson(object);
        System.out.println(json);
    }
    
    @GET
    @Path("factorial/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public int helloworld(@PathParam("number") int number){
        int result = 1;
        for(int i =1; i<=number; i++)
        {
            result *= i;
        }
        return result;
    }
    
    @GET
    @Path("helloname/{name}")
    public String hello(@PathParam("name") final String name) {
      return "Hello " +name;
    }
    
   
    @POST
    @Path("danko")
    @Produces("application/json")
    @Consumes("application/json")
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
  @Produces("application/json")
  @Consumes("application/json")
  public MyGroup intMethod(MyGroup test){
      Student sanya = new Student("Sanya","Sanya","Ivs-15");
      test.setString(sanya);
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
