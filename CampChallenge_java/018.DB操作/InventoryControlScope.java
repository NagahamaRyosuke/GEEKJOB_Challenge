/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;

/**
 *
 * @author Ryosuke
 */
public class InventoryControlScope implements Serializable {
    private String code = "";
    private String product_name = "";
    private String price = "";
    
    public InventoryControlScope(){}
    
    public String getCode(){
        return this.code;
    }
    public void setCode(String n){
        this.code = n;
    }
    public String getProduct_name(){
        return this.product_name;
    }
    public void setProduct_name(String n){
        this.product_name = n;
    }
    public String getPrice(){
        return this.price;
    }
    public void setPrice(String n){
        this.price = n;
    }
        
}
