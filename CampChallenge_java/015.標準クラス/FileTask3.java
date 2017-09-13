/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ryosuke
 */
public class FileTask3 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        File fp = new File("log.txt");
        FileWriter fw = null;
        
        try {
            fw = new FileWriter(fp, true);
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            String line;
            double x;
            
            fw.write(sdf.format(date)+"-開始\r\n");
                      
            for(int i=1; i<11; i++){
                x = Math.sqrt(i);
                System.out.println(i+"の平方根:"+x);
            }
            
            fw.write(sdf.format(date)+"-終了\r\n");
            fw.close();
            
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("error");
        }
        finally {
            try {
                fw.close();
            } catch (IOException ex) {
                System.out.println("error");
            }
        }
  }
}


