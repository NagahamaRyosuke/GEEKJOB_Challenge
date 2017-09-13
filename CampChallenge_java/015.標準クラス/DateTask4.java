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
public class DateTask4 {
    public static void main(String[] args) throws ParseException{
        long d1,d2,result;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date1 = sdf.parse("20150101 00:00:00");
        Date date2 = sdf.parse("20151231 23:59:59");
        
        d1 = date1.getTime();
        d2 = date2.getTime();
        result = d1 - d2;
        
        System.out.println(d1+"-"+d2+"="+result);
    }
}
