/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author Ryosuke
 */
public class StringTask {
    public static void main(String[] args) throws UnsupportedEncodingException{
        String name = "ながはまりょうすけ";
        
        System.out.println("文字の長さ："+name.length());
        System.out.println("文字のバイト数："+name.getBytes("UTF-8").length);
    }
}
