/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

/**
 *
 * @author Ryosuke
 */
public class StringTask2 {
    public static void main(String[] args){
        String adress = "NagahamaRyosuke@gmail.com";
        int num;
        
        num = adress.indexOf("@");
        System.out.println("@以降の文字："+adress.substring(num+1));
    }
}
