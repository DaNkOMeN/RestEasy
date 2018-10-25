/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myrestful;

import com.mycompany.myrestful.model.Formula;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    @Path("arif")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Formula count(Formula form){
       String a = form.getForm();
//       StringBuilder b = new StringBuilder(a);
//       b.append("Jopa");
//       a = b.toString();
//       Formula form2 = new Formula(a);
//        return form2;

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

            if(Character.isDigit(c)){//проверка является ли символ числом
                String strTmp = Character.toString(c);//преобразование char в String
                str1 = str1.concat(strTmp);//склеивание последовательности символов
                x = Double.parseDouble(str1);//преобразование строки чисел в double
                countFirst++;//счетчик первого числа
                count++;//общий счетчик
                countSecond++;//счетчик второго числа

            } else {
                countSecond++;
                count = countSecond;

                charTmp = c;//определяем оператор
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
