/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ryosuke
 */
public class DateTask2 {
    public static void main(String[] args){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        System.out.print(sdf.format(date));
    }    
}
