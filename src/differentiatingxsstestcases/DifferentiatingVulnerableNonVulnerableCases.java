/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package differentiatingxsstestcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author iram
 */
public class DifferentiatingVulnerableNonVulnerableCases {
    private static Scanner x;
    private static Scanner xx;
    List<String> list = new ArrayList<String>();//stores key of maximum value map
    List<String> list1 = new ArrayList<String>();//stores key of maximum value map
    String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression" , "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};


    public void read(String path,String vul,String non){
        try{
            x=new Scanner(new BufferedReader(new FileReader(path))); 
            x.useDelimiter(",");
            while(x.hasNextLine()){
                int zero=0;
                String str1 = Integer.toString(zero);
                int one=1;
                String str = Integer.toString(one);
                String inputline=x.nextLine();
                String[] inarray=inputline.split(",");
                for(int i=0;i<inarray.length;i++){
                     if(inarray[i].matches(".*\\d.*")){
                          if(i==inarray.length-1){
                            if(inarray[i].equals(str1)==false){
                            list.add(inputline); 
                            String[] vularray = list.stream().toArray(String[]::new);
                            insert_into_vulnerablepath(inarray,vul);
                        }
                            if(inarray[i].equals(str)==false){
                            list1.add(inputline);  
                            String[] nonvularray = list1.stream().toArray(String[]::new);
                            insert_into_nonvulnerablepath(inarray,non);
                        }
                    }
                }
        
            }
//         String[] vularray = list.stream().toArray(String[]::new);
//        insert_into_vulnerablepath(vularray,vul);
//        String[] nonvularray = list1.stream().toArray(String[]::new);
//        insert_into_nonvulnerablepath(nonvularray,non);
        }
        
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }    
                
    }
    
    public void insert_into_nonvulnerablepath(String[] array,String non) throws FileNotFoundException{
        
          try{
              FileOutputStream fos= new FileOutputStream(non,true);
              PrintWriter pw=new PrintWriter(fos);
              BufferedReader br = new BufferedReader(new FileReader(non));
              int total=30;
                try {
                if (br.readLine() == null ){
                    pw.println("input size, alert, script,onerror, confirm, img, onload, eval, prompt, src, href, javascript, window, "
                        + "fromcharcode, document, onmouseover, cookie, domain, onfocus, expression, iframe, onclick, singleQuoteMark, "
                          + "doubleQuoteMark, leftAngleBracket, rightAngleBracket, backslant, coma, plus, httpAndFile, vulnerableOrNot");
                    for(int i=0;i<array.length+1;i++){
                          if(i==0){
                            pw.print('\n'+array[i]);
                          }
                          if(i>0 & i<array.length){
                             pw.print(","+array[i]);
                          }
                          if(i==array.length){
                              pw.append('\n');
                          }

                      }
                    } 
                else if (br.readLine() != null ){
                     for(int i=0;i<array.length+1;i++){
                        if(i==0){
                            pw.print(array[i]);
                        }
                        if(i>0 & i<array.length){
                           pw.print(","+array[i]);
                        }
                        if(i==array.length){
                            pw.append('\n');
                        }
                    }}
                }
                catch(Exception e){
                System.err.println("Unable to write the file.");  
              }
              pw.flush();
              pw.close();
            }
           catch(FileNotFoundException e){
              System.err.println("File not found");
            }
    }
    
    
    
     public void insert_into_vulnerablepath(String[] array,String vul) throws FileNotFoundException{
          try{
              FileOutputStream fos= new FileOutputStream(vul,true);
              PrintWriter pw=new PrintWriter(fos);
              BufferedReader br = new BufferedReader(new FileReader(vul));  
              //System.out.println("ayyay length: "+array.length);
              int total=30;
                try {
              if (br.readLine() == null ){
                pw.print("input size, alert, script,onerror, confirm, img, onload, eval, prompt, src, href, javascript, window, "
                      + "fromcharcode, document, onmouseover, cookie, domain, onfocus, expression, iframe, onclick, singleQuoteMark, "
                        + "doubleQuoteMark, leftAngleBracket, rightAngleBracket, backslant, coma, plus, httpAndFile, vulnerableOrNot");
                for(int i=0;i<array.length+1;i++){
                        if(i==0){
                            pw.print('\n'+array[i]);
                        }
                        if(i>0 & i<array.length){
                           pw.print(","+array[i]);
                        }
                        if(i==array.length){
                            pw.append('\n');
                        }
                    
                    
                    }
                } 
              else{
                     for(int i=0;i<array.length+1;i++){
                        if(i==0){
                            pw.print(array[i]);
                        }
                        if(i>0 & i<array.length){
                           pw.print(","+array[i]);
                        }
                        if(i==array.length){
                            pw.append('\n');
                        }

                    }
                    }
                }
                catch(Exception e){
                System.err.println("Unable to write the file.");  
              }
              pw.flush();
              pw.close();
            }
           catch(FileNotFoundException e){
              System.err.println("File not found");
            }
    }
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public static void main(String[] args){
        DifferentiatingVulnerableNonVulnerableCases dvn=new DifferentiatingVulnerableNonVulnerableCases();
        System.out.println("give file path along with its name and extension to read");
        Scanner input=new Scanner(System.in);
        String pat=input.next();
        String path=dvn.modified_path(pat);
        System.out.println("give directory path to save vulnerable payloads");
        String vul_pat=input.next();
        String vul_pah=dvn.modified_path(vul_pat);
        String vul_path=vul_pah+"//"+"vulnerable"+".csv";
        System.out.println("give directory path to save non_vulnerable payloads");
        String non_vul_pat=input.next();
        String non_vul_pah=dvn.modified_path(non_vul_pat);
        String non_vul_path=non_vul_pah+"//"+"nonvulnerable"+".csv";
        dvn.read(path,vul_path,non_vul_path);
    }
    
}
