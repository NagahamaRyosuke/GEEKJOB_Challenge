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
public class QueryStringTask2 {
    public static void main(String[] args){
        int n = 12345;
        int i = 2;
        
        System.out.print(n+" : ");
        while(n != 1){
            if(n % i == 0){
                System.out.print(i+" ");
                n = n / i;
            } else {
                i++;
                if(i > 8){
                    System.out.print(" : "+n);
                    break;
                }
            }
        }
    }
}
