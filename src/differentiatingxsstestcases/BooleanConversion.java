package differentiatingxsstestcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
public class BooleanConversion {
    private static Scanner x;
    List<String> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();

    
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    
   public void BooleanConverter(String path){
       System.out.println("what feature you want to search into?");
        Scanner input=new Scanner(System.in);
        String feature=input.next();
        System.out.println("where you want to save data?");
        String pathi=input.next();
        //this feat is used for non labelled data
        String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression", "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile"};
        
        
        //this feat is used for labelled data where one labelling column is additional
        //String [] feat={"input size","alert","script","onerror","confirm","img","onload","eval", "prompt", "src", "href", "javascript", "window","fromcharcode", "document", "onmouseover", "cookie", "domain", "onfocus","expression", "iframe", "onclick", "singleQuoteMark","doubleQuoteMark", "leftAngleBracket", "rightAngleBracket", "backslant", "coma", "plus", "httpAndFile","label"};

        
        String[] changed=new String[feat.length];
        String[] addData=new String[feat.length];
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
                changed=new String[inarray.length];
                for(int f=0;f<inarray.length;f++){
                    changed[f]=inarray[f];
                }
                for(int i=0;i<inarray.length;i++){
                    if(inarray[i].matches(".*\\d.*")){
                        if(inarray[i].equals(str1)==false){
                            String pandiya;
                            int one=1;
                            pandiya = Integer.toString(one);
                            changed[i]=pandiya;               
                        }             
                    }
                  list.add(changed[i]);                  
                }
                for(int o=0;o<changed.length;o=o+changed.length){       ////changed[] contain data in concatenated form, so to place them in seperate cell, or to perform operation on each term seperately, there is need to split it
                                                                        //takes data in chunk whose size is equal to record size
                    for(int oi=o;oi<changed.length;oi++){               //data within each chunk is saved in array
                        //System.out.print(changed[oi]);                  
                        addData[oi]=changed[oi];
                    }
                    //System.out.println("");
                    insertion(addData,feature,pathi);
                }
            }
           System.out.println("arrays length = "+addData.length); 
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
   }
   public void insertion(String[] array, String feature,String pat){
            String Pati=modified_path(pat);
            String patst= Pati+"\\"+feature+".csv";            
          try{
              FileOutputStream fos= new FileOutputStream(patst,true);
              PrintWriter pw=new PrintWriter(fos);
              BufferedReader br = new BufferedReader(new FileReader(patst));  
                try {
                    if (br.readLine()==null){
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
    
  public static void main(String[] args){
      System.out.println("give path of file(name + extension) that you want to convert to boolean");
      Scanner input=new Scanner(System.in);
      String pa=input.next();
      BooleanConversion BC= new BooleanConversion();
      String path=BC.modified_path(pa);
      BC.BooleanConverter(path);
  }  
}
