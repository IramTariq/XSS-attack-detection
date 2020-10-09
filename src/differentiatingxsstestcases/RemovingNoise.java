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
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author iram
 */
public class RemovingNoise {
    private static Scanner x;

    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    public String removecomaspace(String line){
        String linetoreturn="";
        char zero='0';
        char one='1';
        for(int i=0;i<line.length();i++){
                if(line.charAt(i)==zero){
                    linetoreturn=linetoreturn+line.charAt(i);
                }
                if(line.charAt(i)==one){
                    linetoreturn=linetoreturn+line.charAt(i);
                }
            }
        return linetoreturn;
    }
    public void insertion(String storeplace,String[] array) throws FileNotFoundException{
        FileOutputStream fos= new FileOutputStream(storeplace,true);
        PrintWriter pw=new PrintWriter(fos);
        BufferedReader br = new BufferedReader(new FileReader(storeplace));
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
    
    
    
    
    public void read(String path){
        Scanner input=new Scanner(System.in);
        System.out.println("Give path with name and extension to store unnoised data");
        String pati=input.next();
        String stpath=modified_path(pati);
        try{
            Scanner inputs=new Scanner(System.in);
            System.out.println("give vector which you want to remove");
            String bkwas=inputs.next();
            x=new Scanner(new BufferedReader(new FileReader(path))); 
            x.useDelimiter(",");
            while(x.hasNextLine()){
                String bool;
                int zero=0;
                String str1 = Integer.toString(zero);
                String inputline=x.nextLine();
                String[] inarray=inputline.split(",");
                String[] changed=new String[inarray.length];
                for(int i=0;i<inarray.length;i++){
                    if(inarray[i].matches(".*\\d.*")){
                        if(inarray[i].equals(str1)==false){
                            String pandiya;
                            int one=1;
                            pandiya = Integer.toString(one);
                            changed[i]=pandiya;               
                        }   
                        else if(inarray[i].equals(str1)==true){
                            String pandiya;
                            int zerou=0;
                            pandiya = Integer.toString(zerou);
                            changed[i]=pandiya;               
                        }
                    }
                }
                bool=Arrays.toString(changed);  
                String pandiya;
                pandiya=inputline;
                String modify=removecomaspace(bool);
                System.out.println("bool is: "+bool);
                System.out.println("modify is: "+modify);
                System.out.println("bkwas is: "+bkwas);                
                if(modify.equals(bkwas)==false){
                    insertion(stpath, inarray);
                }
            }
        }
        catch (FileNotFoundException e) {
                    System.err.println("File not found");
        }
    }
    
    
    
    
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("give path of file with name and extention");
        String pati=input.next();
        RemovingNoise rn= new RemovingNoise();
        String path=rn.modified_path(pati);
        rn.read(path);
    }
    
}
