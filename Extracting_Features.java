package differentiatingxsstestcases;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iram
 */
public class Extracting_Features {
    private static Scanner x;
    String strLine = "";
    List<String> list2 = new ArrayList<>();
    
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public void reading(String path){
        System.out.println("what feature you want to search into?");
        Scanner input=new Scanner(System.in);
        String feature=input.next();
        String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression" , "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
        int index=0;
        for(int k=0;k<feat.length;k++){
            if(feature.equals(feat[k].toString()))
                index=k;      
            }
        try{
            x=new Scanner(new BufferedReader(new FileReader(path))); 
            x.useDelimiter(",");
            while(x.hasNextLine()){
                int zero=0;
                String str1 = Integer.toString(zero);
                String inputline=x.nextLine();
                String[] inarray=inputline.split(",");
                for(int i=0;i<inarray.length;i++){
                    if(i==index){
                        if(inarray[i].equals(str1)==false){
                            String pandiya;
                            pandiya=inputline;
                            list2.add(pandiya);               
                        }
                    }
                }
            } 
        String[] arr=new String[list2.size()];
        for(int j=0;j<list2.size();j++){
            arr=list2.toArray(new String[0]);
        }
        insertion(arr,feature);  
           
            
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
    }
    public void insertion(String [] array, String feature) {
        System.out.println("enter (name of directory) where you want to save");
              Scanner input=new Scanner(System.in);
              String pat=input.next();
              String Pati=modified_path(pat);
              String patst= Pati+"\\"+feature+".csv";
             System.out.println("arrays length = "+array.length);
          try{
              FileOutputStream fos= new FileOutputStream(patst,true);
              PrintWriter pw=new PrintWriter(fos);
              BufferedReader br = new BufferedReader(new FileReader(patst));  
                try {
                    if (br.readLine()==null){
                        for(int i=0;i<array.length;i++){
                           pw.println(array[i]);
                        }
                    }
                    else{
                        for(int i=0;i<array.length;i++){
                           pw.println(array[i]);
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

    public static void main(String[] args){
        System.out.println("Give path of file (with its name and extension) that you want to search into");
        Scanner input=new Scanner(System.in);
        String path=input.next();
        Extracting_Features ex=new Extracting_Features();
        String npath=ex.modified_path(path);
        ex.reading(npath);
    }
}
