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
public class StringTask3 {
    public static void main(String[] args){
        String word = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        
        word = word.replace("I", "い");
        word = word.replace("U", "う");
        
        System.out.println(word);
    }
}
