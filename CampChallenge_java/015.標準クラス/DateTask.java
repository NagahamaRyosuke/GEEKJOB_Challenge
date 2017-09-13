/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ryosuke
 */
public class DateTask {
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = sdf.parse("20160101 00:00:00");
        
        System.out.println(date);
        System.out.println(date.getTime()); 
    }  
}
