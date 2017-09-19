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
public class QueryStringTask {
    public static void main(String[] args){
        String url = "http://localhost:8080/abc.jsp?total=1500&count=10&type=2";
        int total = 3000;
        int count = 10;
        int type = 2;
        int price = 0;
        int point = 0;
        
        if(type == 1){
            System.out.println("雑貨");
        } else if(type == 2){
            System.out.println("生鮮食品");
        } else if(type == 3){
            System.out.println("その他");
        }
        
        price = total / count;
        System.out.println("一個当たりの値段:"+price);
        
        if((total >= 3000)&&(total <= 4999)){
            point = (int) (total * 0.04);
        } else if(total >= 5000){
            point = (int)(total * 0.04);
        }
        System.out.println(point);
    }
}
