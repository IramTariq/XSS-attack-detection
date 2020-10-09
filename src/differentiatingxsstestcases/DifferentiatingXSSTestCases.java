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
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author iram
 */
public class DifferentiatingXSSTestCases {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        String strLine = "";
        String data;

    public void read(String Path){
        String filepath;
        filepath = modified_path(Path);
        try {
             BufferedReader br = new BufferedReader(new FileReader(filepath));
              while (strLine != null)
               {
                strLine = br.readLine();
                list.add(strLine);
                if (strLine==null)
                   break;
            }
              int n=list.size();
              int counting=0;
              String [] nw = new String [n];
              String mpa=modified_path(Path);
              for(int i=0;i<list.size()-1;i++){
                  int j=i;
                  nw[i]=list.get(i);
                  nw[i] = nw[i].replaceAll("%(?![0-9a-fA-F]{2})", "%25");
                  String result = java.net.URLDecoder.decode(nw[i], (StandardCharsets.UTF_8).toString());
                  list2.add(result);
                  String data=list2.get(i).toString();
                  counting++;
                  Checking_xss(data,Path);
              }
               
              String[] stockArr = new String[list3.size()];
              stockArr = list3.toArray(stockArr);
              insertion(stockArr);
              br.close();
             }
                catch (FileNotFoundException e) {
                    System.err.println("File not found");
                }
                catch (IOException e) {
                    System.err.println("Unable to read the file.");
                }
    }
    public void Checking_xss(String d, String Path){    
        boolean exist=false;
        for(int i=0;i<d.length()-3;i++){
            if(d.charAt(i)=='x'){
                if(d.charAt(i+1)=='s'){
                    if(d.charAt(i+2)=='s'){
                        exist=true;
                    }              
                } 
            } 
        }
        if(exist==true){
            list3.add(d);
            exist=false;
        }
    }
    public void insertion(String [] array) {
        System.out.println("enter where you want to save");
              Scanner input=new Scanner(System.in);
              String pat=input.next();
              String Pati=modified_path(pat);
              System.out.println("suggest name of file");
              String nam=input.next();
              String patst= Pati+"\\"+nam+".csv";
             System.out.println("arrays length = "+array.length);
          try{
              FileOutputStream fos= new FileOutputStream(patst,true);
              PrintWriter pw=new PrintWriter(fos);
              BufferedReader br = new BufferedReader(new FileReader(patst));  
                try {
                    if (br.readLine() == null ){
                        pw.println(" test name, CWE, real vulnerability,identified by tool, pass/fail");
                        for(int i=0;i<array.length+1;i++){
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
    public String modified_path(String path){
        String changed_path;
        String slash = "\\";
        String escapedSlash = slash+slash;
        String twoEscapedSlashes = escapedSlash+escapedSlash;
        changed_path=path.replaceAll(escapedSlash, twoEscapedSlashes) ;
        return changed_path;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    System.out.println("give file path");
    String pa;
    Scanner input=new Scanner(System.in);
    pa=input.next();
    DifferentiatingXSSTestCases re=new DifferentiatingXSSTestCases();
    re.read(pa);
    }
}
