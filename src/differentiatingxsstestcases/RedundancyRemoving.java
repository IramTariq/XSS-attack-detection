/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package differentiatingxsstestcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet; 


/**
 *
 * @author iram
 */
public class RedundancyRemoving {
     private static Scanner x;
     List<String> list = new ArrayList<>();
    
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public void removal(String path) throws IOException{
        String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression", "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
        String[] changed=new String[feat.length];
        String[] addData=new String[feat.length];
        System.out.println("where you want to save data? (Give name and extension)");
        Scanner input=new Scanner(System.in);
        String pathi=input.next();//path to store data
        String pati=modified_path(pathi);
        try{
            // PrintWriter object for output.txt 
        PrintWriter pw = new PrintWriter(pati); 
          
        // BufferedReader object for input.txt 
        BufferedReader br = new BufferedReader(new FileReader(path)); 
          
        String line = br.readLine(); 
          
        // set store unique values 
        HashSet<String> hs = new HashSet<String>(); 
          
        // loop for each line of input.txt 
        while(line != null) 
        { 
            if(hs.add(line)) 
                pw.println(line); 
              
            line = br.readLine(); 
              
        } 
          
        pw.flush(); 
          
        // closing resources 
        br.close(); 
        pw.close(); 
          
        System.out.println("File operation performed successfully"); 
    }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
} 
        
        
    public static void main(String[] args) throws IOException{
        System.out.println("Give file name(name+extension) for which you want to remove redundancy");
        Scanner input=new Scanner(System.in);
        String pa=input.next();
        RedundancyRemoving rr=new RedundancyRemoving();
        String path=rr.modified_path(pa);
        rr.removal(path);
    }
}
